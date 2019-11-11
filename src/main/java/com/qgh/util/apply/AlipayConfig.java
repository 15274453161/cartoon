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
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCCIroSrIyOV0g0mSVl7Zyziln4rviIbpfYpdmvoDWClAGqHQXB3Ax6+hq7tmOMtjCrejsBumEUM8P9YDeFY0+/YtVSaadqvgULoTcie1pS9pXsQ3VADmXNZ8MNEEod+Vxa9sWSryk1yyrMyABwe1gWceYZr2ZtavmoIlOysYRQfUU3ueJYDdxFwL7TuAozq1f6GltJkBO5cmUCJOoJ0DbYdRHMsRKym/mDUoh5V8CmfmeClow6BfVh+ypVWsDgPAUgoqfb9hJw1PJm5P9XPOOYvh8h6etQx3cuCgrw4bDV0WyRRy2DBwCW312i1ZziZeA09EWB9u/1r2eJTYT6Ws2nAgMBAAECggEAQWeGsV/7fIatiZH209WqTioYsf3ud1NuCbrBP517h1cvxvmzLQ2VUDFnQjSWr9/ZcjWKdoHfzLF/rVawUN/q8ruPj03+kI1UJ9Ysya3JZaz9CLOWuE0EKUofI++t8IalPiqMff5+7cRgjG9wmRfE2/L+vKYFCrUbKL+n5UWGxJSZqKPg5bUsckZfEVwiBzrJPK0/bnqPQsTcdY46//WVAedPUPBH1PQMuuyuDQ48Xr/XrrGhCMCkkbl6x2f0jwJu9qT/yTmTHh+GoPWpT5x0ZJj/H4rL4YrqSfOGvI5Pfehspqbh3CFk3ElKg/AiYfA4d3Za2lzRL6rngvgPwRogwQKBgQC8OcyWTo8PUWneq0zE9OkMuAHmQ4dvz/gxyHdYosQH0eYWcbIR86qI1cqFLYdXq4D6Eqt1Wk259v0aQ3XTTvVsGa+xWBCdWmcgA6GZYQWlU118VzNrguPMOZWwK0/sKla5cqE4Jxgx7CeDevQY/Zoolzuba2na09FCSYJfa5d3UQKBgQCw/lGznMMR+cYF2uPWV1QIw3ulEsO/7Zx3Qnx9eSL+y6SYNiy2fxZ8HGXyloiZgJOVJhqAcr2dn9PLM5a1hcfhYLPVf0zXGN1M062EeyMs6lLJveerpvnB9C0YCgi+jyh7MsQsNQ/ss3ftc8tkoisAQeD/4yn9pBkAuI+bMDUndwKBgDxhzl/pk7s2QuBL07TbXGfYH8PepfQYo2ZVCPRGQty/WTCaCKX5pRuAehd/I4vcWOPgWWCsN4MQ2OE0AvhmvBSRqOsbdTkFZ0+92nl5xnXi6Hqa/sPemXVKg9qgCmOYsXmMbGu3Huvk9kgXiXb65Blhap3RN4Qbr2W0bz5tJYoBAoGAfrI+R+ViWf7C+rP6vhcbJ37PhpXNHBl6FIC6XpMVMvERbIfzL9v/e25Up/eL5t38RxrUg7ge9bNQR7gxHNWcBEBV2vFaTusUlwc7wYbn4iIGizVunhhT1rv0f63HHqmZn77yYHbHZHf/1DE8mlffkjqWVnYFO/R4lWSIH929XvcCgYBGtItvgneVANTgEeOx2L57faFoTBqxrdVWCfj6dXFXW+1DxwipMFfnLPJRZcc4FkZEOdwWoxXSONOebo/9agGIJh9zzn6W4Kw6vvnrge48Wj6XNrG858ww4M+3Qk49+ZxnEEsjKdAjqUtk8+RCdi0TipDOWRbV5D0qdyyfaaqCfA==";
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
