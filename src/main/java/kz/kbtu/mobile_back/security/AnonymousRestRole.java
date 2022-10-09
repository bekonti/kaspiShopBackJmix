//package kz.kbtu.mobile_back.security;
//
//import io.jmix.security.model.EntityAttributePolicyAction;
//import io.jmix.security.role.annotation.EntityAttributePolicy;
//import io.jmix.security.role.annotation.EntityPolicy;
//import io.jmix.security.role.annotation.ResourceRole;
//
//@ResourceRole(name = "AnonymousRestRole", code = AnonymousRestRole2.CODE, scope = "API")
//public interface AnonymousRestRole {
//    String CODE = "anonymous-rest-role";
//
//    @EntityAttributePolicy(entityClass = Product.class,
//            attributes = "*",
//            action = EntityAttributePolicyAction.MODIFY)
//    @EntityPolicy(entityClass = Product.class,
//            actions = {EntityPolicyAction.READ, EntityPolicyAction.UPDATE})
//}
