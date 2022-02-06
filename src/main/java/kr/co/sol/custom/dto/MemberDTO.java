package kr.co.sol.custom.dto;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

import lombok.Getter;

import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@ToString
public class MemberDTO {

    private String mem_id    ;
    private String m_passwd  ;
    private String m_name    ;
    private String m_email   ;
    private String m_phone   ;
    private String zipcode   ;
    private String address   ;
    private String address2  ;
    private String m_job     ;
    private String m_roll     ;
    
    
    
}