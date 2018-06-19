package cn.jastz.product.service;

import cn.jastz.product.BaseTest;
import cn.jastz.product.form.SkuAttrAddForm;
import org.junit.Test;

/**
 * @author zhiwen
 */
public class SkuAttrServiceTest extends BaseTest<SkuAttrService> {

    @Test
    public void addSkuAttr() {
        SkuAttrAddForm skuAttrAddForm = new SkuAttrAddForm();
        skuAttrAddForm.setAppId(getAppId());
        skuAttrAddForm.setAttrName("尺寸");
        skuAttrAddForm.setAttrCode("size");
        skuAttrAddForm.setAttrDesc("通用尺寸属性");
        skuAttrAddForm.setSkuCategoryId(5);
        service.addSkuAttr(skuAttrAddForm);

        skuAttrAddForm = new SkuAttrAddForm();
        skuAttrAddForm.setAppId(getAppId());
        skuAttrAddForm.setAttrName("颜色");
        skuAttrAddForm.setAttrCode("color");
        skuAttrAddForm.setAttrDesc("通用颜色属性");
        skuAttrAddForm.setSkuCategoryId(5);
        service.addSkuAttr(skuAttrAddForm);

        skuAttrAddForm = new SkuAttrAddForm();
        skuAttrAddForm.setAppId(getAppId());
        skuAttrAddForm.setAttrName("内存");
        skuAttrAddForm.setAttrCode("ROM");
        skuAttrAddForm.setAttrDesc("通用内存属性");
        skuAttrAddForm.setSkuCategoryId(5);
        service.addSkuAttr(skuAttrAddForm);
    }

}
