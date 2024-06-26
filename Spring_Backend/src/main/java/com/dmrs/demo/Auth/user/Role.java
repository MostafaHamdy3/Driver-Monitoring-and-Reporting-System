package com.dmrs.demo.Auth.user;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@Data
@Document
public class Role implements GrantedAuthority {
    @Id
    private String roleId;

    @Indexed(unique = true)
    private String authority;

    @Override
    public String getAuthority() {
        return authority;
    }

    public Role(){
        super();
    }

    public Role(String authority){
        this.authority = authority;
    }

    public Role(String roleId, String authority){
        this.roleId = roleId;
        this.authority = authority;
    }


}
