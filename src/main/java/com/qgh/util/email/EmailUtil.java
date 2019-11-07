package com.qgh.util.email;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;


@Service
public class EmailUtil {

    private final static String VERIFICATION_CODE="你的验证码是：";

    private final static String FIND_WORD="系统将你的密码修改为：";

    private String vertifyCode;

    Logger log= LoggerFactory.getLogger(EmailUtil.class);

    @Autowired
    private JavaMailSenderImpl javaMailSender;
//    @Autowired
//    private RedisService redisService;

    @Value("${spring.mail.username}")
    private String emialSend;


    /**
     * 发送一封邮件
     * @param receiveEmail 收件人邮箱
     * @param content 邮件内容 截取的四位数的随机数
     */
    private void sendMessage(String receiveEmail,String content){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(emialSend);
        message.setTo(receiveEmail);
        message.setSubject("来自CloudMusic的邮件");
        message.setText(content);
        new Thread(new Runnable() {
            @Override
            public void run() {
                javaMailSender.send(message);
                log.info("邮件发送完毕");
            }
        }).start();
    }

    /**
     * 发送验证码邮件并将验证码存入缓存
     * @param receiveEmail
     */
    public void sendVerificationCode(String receiveEmail){
        String randomCode= UUID.randomUUID().toString().replaceAll("-","").substring(0,5);
        vertifyCode=randomCode;
        sendMessage(receiveEmail,VERIFICATION_CODE+randomCode);
    }

    public String getVertifyCode(){
        return vertifyCode;
    }

    /**
     * 发送验证码邮件并将验证码,外部
     * @param receiveEmail
     * @param randomCode
     */
    public void sendVerificationCode(String receiveEmail,String randomCode){
        //String randomCode= UUIDUtil.randomUUID().substring(0,5);
        //redisService.set(EmailKey.VERIFICATION_CODE,receiveEmail,randomCode);
        sendMessage(receiveEmail,VERIFICATION_CODE+randomCode);
    }

    /**
     * 发送修改后的密码
     * @param receiveEmail
     * @param newPassword
     */
    public void sendFindPassword(String receiveEmail,String newPassword){
        sendMessage(receiveEmail,FIND_WORD+newPassword);
    }






}
