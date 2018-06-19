package org.zstack.identity.rbac

import org.zstack.header.identity.AccountConstant
import org.zstack.header.identity.InternalPolicy
import org.zstack.header.identity.PolicyInventory
import org.zstack.header.identity.StatementEffect
import org.zstack.header.identity.rbac.RBACGroovy

class SystemInternalPolicy implements InternalPolicy {
    @Override
    List<PolicyInventory> getPolices() {
        return InternalPolicyDefiner.New {
            policy {
                name = "system-internal-policy"

                statement {
                    name = "normal-account-allowed-apis"
                    effect = StatementEffect.Allow

                    RBACGroovy.rbacInfos.each { info ->
                        info.normalAPIs.each { action(it) }
                    }
                }

                statement {
                    name = "give-admin-all-apis"
                    effect = StatementEffect.Allow

                    action("**")

                    principal("${AccountConstant.PRINCIPAL_ACCOUNT}:${AccountConstant.INITIAL_SYSTEM_ADMIN_UUID}")
                }
            }
        }
    }
}
