package org.zstack.ldap

import org.zstack.ldap.APIDeleteLdapBindingEvent

doc {
    title "DeleteLdapBinding"

    category "ldap"

    desc "在这里填写API描述"

    rest {
        request {
			url "DELETE /v1/ldap/bindings/{uuid}"


            header (OAuth: 'the-session-uuid')

            clz APIDeleteLdapBindingMsg.class

            desc ""
            
			params {

				column {
					name "uuid"
					enclosedIn ""
					desc "资源的UUID，唯一标示该资源"
					location "url"
					type "String"
					optional false
					since "0.6"
					
				}
				column {
					name "systemTags"
					enclosedIn ""
					desc ""
					location "body"
					type "List"
					optional true
					since "0.6"
					
				}
				column {
					name "userTags"
					enclosedIn ""
					desc ""
					location "body"
					type "List"
					optional true
					since "0.6"
					
				}
			}
        }

        response {
            clz APIDeleteLdapBindingEvent.class
        }
    }
}