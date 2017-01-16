package com.pch.study.service;

import com.pch.common.po.Result;
import com.pch.common.util.ResultUtil;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;

/**
 * @author uo712
 * @version 1.0
 * @since 2017/1/16
 */
@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private freemarker.template.Configuration configuration;

    @Autowired
    private JavaMailSenderImpl mailSender;


    @Override
    public Result<?> sendMail(ModelMap modelMap) {
        try {
            Template template = configuration.getTemplate("adviserNotice.ftl");
            String content = FreeMarkerTemplateUtils.processTemplateIntoString(template, modelMap);

            MimeMessage message = mailSender.createMimeMessage();
// use the true flag to indicate you need a multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo("651158394@qq.com");
            helper.setText(content, true);
            FileSystemResource file = new FileSystemResource(new File("D:" + File.separator + "mv.jpg"));
            helper.addAttachment("mv.jpg", file);
            FileSystemResource res = new FileSystemResource(new File("D:" + File.separator + "mv.jpg"));
            helper.addInline("mv", res);
// attach the infamous windows Sample file
            mailSender.send(message);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return ResultUtil.getResult(null);
    }
}
