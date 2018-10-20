package com.contenderapps.apc.injection.scopes;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * todo: document well this annotation
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PerPresenter {
}
