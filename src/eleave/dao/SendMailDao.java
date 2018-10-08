/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eleave.dao;

/**
 *
 * @author khoerulAbu
 */
public interface SendMailDao {
    
    public String getSmtpHost(String parameter);

    public String getSmtpAuth(String parameter);

    public String getSmtpPort(String parameter);

    public String getSmtpSender(String parameter);

    public String getSmtpPassword(String parameter);
    public String getSubjectRequestCuti(String parameter);
    public String getContentRequestCuti(String parameter);
    public String getSmtp(String parameter);
    
}
