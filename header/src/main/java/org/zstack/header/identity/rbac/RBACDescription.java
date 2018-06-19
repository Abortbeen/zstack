package org.zstack.header.identity.rbac;

import java.util.ArrayList;
import java.util.List;

public interface RBACDescription {
    default RBAC.PermissionBuilder permissionBuilder() {
        return new RBAC.PermissionBuilder();
    }

    default RBAC.RoleContributorBuilder roleContributorBuilder() {
        return new RBAC.RoleContributorBuilder();
    }

    default RBAC.RoleBuilder roleBuilder() {
        return new RBAC.RoleBuilder();
    }

    default RBAC.GlobalReadableResourceBuilder globalReadableResourceBuilder() {
        return new RBAC.GlobalReadableResourceBuilder();
    }

    default void registerAPIPermissionChecker(Class aClz, boolean takeOver, APIPermissionChecker checker) {

        List<RBAC.APIPermissionCheckerWrapper> ws = RBAC.permssionCheckers.computeIfAbsent(apiClz, x->new ArrayList<>());
        RBAC.APIPermissionCheckerWrapper w = new RBAC.APIPermissionCheckerWrapper();
        w.takeOver = takeOver;
        w.checker = checker;
        ws.add(w);
    }

    default void registerAPIPermissionChecker(Class apiClz, APIPermissionChecker checker) {
        registerAPIPermissionChecker(apiClz, false, checker);
    }

    default RBACEntityFormatter entityFormatter() {
        return null;
    }

    void permissions();

    void contributeToRoles();

    void roles();

    void globalReadableResources();
}
