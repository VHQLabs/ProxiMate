package com.contenderapps.apc.data.models.base;


import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 *
 */
public class BaseModelTest {


    @Test
    public void testConstantExistence() {
        BaseModel baseModel = new BaseModel() {
            @Override
            public String toString() {
                return Long.toString(getSerialVersionUID());
            }

            public long getSerialVersionUID() {
                return serialVersionUID;
            }
        };
        assertEquals(baseModel.toString(), "1");
    }



}
