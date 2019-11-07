package com.qgh.util.apply;

/**
 * @title:沙箱支付配置类
 * @ClassName: AlipayConfig
 * @Description:
 * @Auther: 秦光泓
 * @date 2019/11/3
 * @time 20:52
 */
public class AlipayConfig {
    // 应用ID,支付宝提供的APPID，上面截图中有提到
    public static String app_id = "2016101700704179";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCn8D4npPGZfNxY0Q6LjzrQoiMjKsPfEvQAjTAiG8SeggtIqrf2Vc4xms8xOI6IaYWoqT7RvyO6Bmy65V9L9pYFG2R5F2g9XvkkE168uW4vUoFYnhXunTh2Ne383G5kO6mCFFK6a3EyNvnlw/T41e84LWKxAcU0oUqk119W4gHr5v07+bSWxNe4Kl+2pB45AS9TFiqMjWdr1fig5KXrgS/f23qR+6NNrxOz4e91wMkS2HHsqKMRIzG5rJ+hu8hXFLhorC9LC9D3i+a0EOksdvhEXdBrDowGsDZl2NbYWgazoebDn2Eap2Jgqu3Xe6omXlnCo2mrD4N2XHFjLv+bcOCpAgMBAAECggEAR8XkOntDCi8T2R2X0stm/o2c6MW5KphmEepFfP5THM9FVUwpDS2Ezyxziny6ZdB7YCbdAzVmZnWieInZHZUIbqxTV3FKipgRcHqazZuOXMktIJuHkhA9dj/8M0peH5ZkDoTzClsq6KQYTztdcg+0ilTTTgUMrD6WsTaet3omChRf3ao8ElmVLiL6UzLBPkyKxY77iCYAR1hkSKeuwhNUJ3tYQ8710cRK/oJVkbD1Aj5ok+zF+VS5ekBXJm0LYRP/MMkfHrxeLwQl1A1NWm+D/tOjpQuea4L72NcPXLCbQtBaKs7er+mwmIMXILPiBq9z6nVpvLWkTv6YC5BYOOX8dQKBgQDdfwyxRS0XFid7gsbLiacHtH+XEMwNEUxrsaUJqtOu7YsPmyVkKKSU+XYz30sdHtR1ExWqT3yMvLctWSk+SR2CWlnKwfhxGOH3DFtunAEVuEIe1cnSKVKgydq6HM5ztM1WaE5Oka8e/3qMwHMzu+rLHpb7N5dRzYhdF65TobLrnwKBgQDCGWJj5RiQzmSvMIAVJ4/1+HRBQBga62FwVdgpNfADRj3Pr0mdNxm3FjXFHH3kJxhC/JFRfF+E9knN4HLcslNNcm20IuVkbVW9mmQOgWPUZURQ+h2tEVAsQU6kaGimqSNSn81AgG39Zw9HG2k2CcYq3HKv5EoJh4hYdYGRx0BOtwKBgFt7agadh64NXGlK7kiKpg4sorYGHgEXr/Sa/osrnxqUyea8MYlYsAFHt2ZdR2zTmvRv2XbqNYr7NrzoInyzPhjksElqK+6qVEnxNKJOlLQf0k9iBWVj49i9BjXwR+TKPDUAB7ezvByVcExKAErRxnv2Om2v3DPRLA0nBr1L/9YJAoGAe1eCLJSyraJaXPFnEwpW8yl1Rtmh98lH3AjRGi8KXCpQsR9kmiEfmDbm6GEYptkpE7hH6A4u7OFNOSS+GPzA7uAeUnAycUUBTUFE/+q9M4U+im7GWOo9lkHR5avrhKzKo4Ck/64dNwA8tyT2EL7ZTPdVceySF8gmnn/dXHPPq7UCgYAKtNuO5BwyK1X2M+iZhKBm6cqbE2B014x86SeFI2KWKhxixU1HRbRVLC+PphGFcUZaXkrT2KctG+qdo2j46FWsrOrCEW2k1ZS/2KGk220lG0vXkfMxbJG9WMhE0psD7WMKSo9IRDCxhAkDx3CypstgOVAPetwkL42QLbEOkqqygQ==";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/appDaily.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA4KzYHU1kb8m/C1NNhF0WARszPp9UCUP3+P1NDI8+y5I+C8l1254kWdBpaefo3N71L/gtX2WYlfAbsJKYeDHSQMVtV3Nudo6JxEYK4B3vno/+uYytcG9+j4iYyiSAXgUu03lHZOUpD8iVH0kQCf9Xj4LybWu3f+xTt+Blkzr9gl9fO8Wl1SbRK1knl1B7x9gphSFOzMMTn6DB4QIwNTpV3t19sclGi4is1Yk562qXuQfSfec0XlLqHi9WlJi0hW1ow+FfnXX+PaHEpBv8JHxhXEwTK8M6a2XoeCustFo3Noa3HAymxl9DncVVCN4KGP1IWMYMN2IWhXBB4qrP2QSQmwIDAQAB";

    // 服务器异步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问.如果只是测试使用,那么设置成自己项目启动后可以访问到的一个路径,作为支付宝发送通知的路径(有什么用暂时没发现)
    public static String notify_url = "http://localhost:8080/pay/alipay-callback-notify-url";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问.如果只是测试使用,那么设置成自己项目启动后可以访问到的一个路径.是支付正常完成后,会访问的路径.
    public static String return_url = "http://localhost:8080/pay/alipay-callback-return-sult";
    // 签名方式，注意这里，如果步骤设置的是RSA则用RSA,如果按照扇面步骤做的话,选择RSA2
    public static String sign_type = "RSA2";
    // 字符编码格式
    public static String charset = "utf-8";
    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
}
