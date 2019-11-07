package com.qgh.util.result;

/**
 * 封装好的发送到前端的结果集
 *
 * @author 秦光泓
 */
public class Result {
    public final static Result SUCCESS = new Result("2000", "成功");

    public final static Result FAILURE = new Result("5000", "失败");

    /**
     * 用户状态码，
     * 错误以50***开头
     * 正确以20***开头
     */
    public final static Result LOGIN_SUCCESS = new Result("2001", "登陆成功");

    public final static Result REGISTER_SUCCESS = new Result("2002", "注册成功");

    public final static Result NO_EMAIL = new Result("5001", "该邮箱不存在");

    public final static Result PASS_ERROR = new Result("5002", "密码错误");

    public final static Result HAD_Login = new Result("5003", "已在其他客户端登录");

    public final static Result HAD_REGISTER = new Result("5004", "邮箱已被注册");

    public final static Result CODE_ERROR = new Result("5005", "验证码错误");

    public final static Result CODE_INVALID = new Result("5006", "验证码失效，请重新发送");

    public final static Result NO_LOGIN = new Result("5008", "尚未登录");

    /**
     * 评论状态码。
     * 错误以51***开头
     * 正确以21***开头
     */
    public final static Result COMMENT_ILLEGAL = new Result("5100", "尚未登录");


    /**
     *
     */


    public final static Result ADMIN_NO = new Result("521", "该账户不是管理员");

    public final static Result PASS_NOT_EQUAL = new Result("522", "两次密码不一致");

    private String code;
    //当前页
    private int pageSize;
    //总的页数
    private int pages;

    private Object msg;

    public Result(String code, Object msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(String code, Object msg, int pageSize) {
        this.code = code;
        this.msg = msg;
        this.pageSize = pageSize;
    }

    public Result(String code, Object msg, int pageSize, int pages) {
        this.code = code;
        this.msg = msg;
        this.pageSize = pageSize;
        this.pages = pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public static Result SUCCESS(Object object) {
        return new Result("2000", object);
    }

    public static Result SUCCESS(Object object, int pageSize) {
        return new Result("2000", object, pageSize);
    }

    public int getPages() {
        return pages;
    }

    public static Result SUCCESS(Object object, int pageSize, int pages) {
        return new Result("2000", object, pageSize,pages);
    }

    public static Result FAILURE(Object object) {
        return new Result("5000", object);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }


    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code='" + code + '\'' +
                ", pageSize=" + pageSize +
                ", msg=" + msg +
                '}';
    }
}
