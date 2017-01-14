package org.zstack.header.zone

import org.zstack.header.zone.APIDeleteZoneEvent

doc {
    title "DeleteZone"

    category "zone"

    desc "在这里填写API描述"

    rest {
        request {
			url "DELETE /v1/zones/{uuid}"


            header (OAuth: 'the-session-uuid')

            clz APIDeleteZoneMsg.class

            desc ""
            
			params {

				column {
					name "uuid"
					enclosedIn "zone"
					desc "资源的UUID，唯一标示该资源"
					location "url"
					type "String"
					optional false
					since "0.6"
					
				}
				column {
					name "deleteMode"
					enclosedIn "zone"
					desc ""
					location "body"
					type "String"
					optional true
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
            clz APIDeleteZoneEvent.class
        }
    }
}