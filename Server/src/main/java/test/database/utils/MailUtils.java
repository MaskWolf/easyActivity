package test.database.utils;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * 发邮件工具类
 */
public final class MailUtils {
    private static final String USER = "2873387076@qq.com"; // 发件人称号，同邮箱地址
    private static final String PASSWORD = "thdfcwsfzmvwdgjd"; // 如果是qq邮箱可以使户端授权码，或者登录密码

    /**
     * @param to    收件人邮箱
     * @param text  邮件正文
     * @param title 标题
     */
    /* 发送验证信息的邮件 */
    public static boolean sendMail(InputStream inputStream,String to, Object text, String title,String fileName) {
        try {
            final Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            //设置发送给邮件的邮件服务器的属性
            props.put("mail.smtp.host", "smtp.qq.com");

            // 发件人的账号
            props.put("mail.user", USER);
            //发件人的密码
            props.put("mail.password", PASSWORD);

            // 构建授权信息，用于进行SMTP进行身份验证
            Authenticator authenticator = new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    // 用户名、密码
                    String userName = props.getProperty("mail.user");
                    String password = props.getProperty("mail.password");
                    return new PasswordAuthentication(userName, password);
                }
            };
            // 使用环境属性和授权信息，创建邮件会话
            Session mailSession = Session.getInstance(props, authenticator);
            // 创建邮件消息
            MimeMessage message = new MimeMessage(mailSession);

            // 设置发件人
            String username = props.getProperty("mail.user");
            InternetAddress form = new InternetAddress(username);
            message.setFrom(form);

            // 设置收件人
            InternetAddress toAddress = new InternetAddress(to);
            message.setRecipient(Message.RecipientType.TO, toAddress);

            // 设置邮件标题
            message.setSubject(title);

            //向Multipart对象中添加邮件的各部分内容，包括文本内容和附件
            Multipart multipart = new MimeMultipart();

            // 设置邮件的内容体
            BodyPart contentPart = new MimeBodyPart();
            contentPart.setText(text + ",请查看附件内容");
            message.setContent(text, "text/html;charset=UTF-8");
            multipart.addBodyPart(contentPart);
            //添加附件
            BodyPart messagePart = new MimeBodyPart();
            DataSource source = new ByteArrayDataSource(inputStream,"application/msexcel");
            //添加附件内容
            messagePart.setDataHandler(new DataHandler(source));
            //添加附件标题
            messagePart.setFileName(fileName + ".xlsx");
            multipart.addBodyPart(messagePart);
            //将multipart对象添加到message中
            message.setContent(multipart);
            // 发送邮件
            Transport.send(message);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) throws Exception { // 做测试用
        File file = new File("a.txt");
        InputStream inputStream = MailUtils.class.getClassLoader().getResourceAsStream("a.txt");
        String path = MailUtils.class.getClassLoader().getResource("a.txt").getPath();
        System.out.println("path:" + path);
        MailUtils.sendMail(null,"wy2017211@163.com", "你好，这是一封测试邮件，无需回复。", "测试邮件","图灵运动挑战赛");
        System.out.println("发送成功");
    }

}