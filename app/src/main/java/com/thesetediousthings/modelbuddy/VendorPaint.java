package com.thesetediousthings.modelbuddy;

public class VendorPaint {

    private String sku;
    private String code;
    private String desc;
    private int vendor;
    private int type;

    public static final int SKU = 1;
    public static final int CODE = 2;
    public static final int VENDOR_TAMIYA = 1;
    public static final int VENDOR_MRHOBBY = 2;
    public static final int VENDOR_HUMBROL = 3;
    public static final int TYPE_ACRYLIC = 1;
    public static final int TYPE_ENAMEL = 2;
    public static final int TYPE_AIRMODEL_SPRAY = 3;
    public static final int TYPE_SPRAY = 4;

    public static final String IMG_URL_TAMIYA_ACR_FLAT_PREFIX = "https://www.tamiya.com/english/products/list/acrylic_flat/img/";
    public static final String IMG_URL_TAMIYA_ACR_GLOSS_PREFIX = "https://www.tamiya.com/english/products/list/acrylic_gloss/img/";
    public static final String IMG_URL_TAMIYA_ENML_FLAT_PREFIX = "https://www.tamiya.com/english/products/list/enamel_flat/img/";
    public static final String IMG_URL_TAMIYA_ENML_GLOSS_PREFIX = "https://www.tamiya.com/english/products/list/enamel_gloss/img/";
    public static final String IMG_URL_TAMIYA_AIRMODELSPRAY_PREFIX = "https://www.tamiya.com/english/products/list/airmodel_spray/img/";
    public static final String IMG_URL_TAMIYA_SPRAY_PREFIX = "https://www.tamiya.com/english/products/list/tamiya_spray/img/";

    public static final String IMG_URL_TAMIYA_SUFFIX = ".gif";
    public static final String IMG_URL_MRHOBBY_PREFIX = "";
    public static final String IMG_URL_MRHOBBY_SUFFIX = "";
    public static final String IMG_URL_HUMBROL_PREFIX = "";
    public static final String IMG_URL_HUMBROL_SUFFIX = "";

    public VendorPaint(String sku, String code, String desc, int vendor) {
        this.sku = sku;
        this.code = code;
        this.desc = desc;
        this.vendor = vendor;
    }

    public String getSku() {
        return sku;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public int getVendor() {
        return vendor;
    }

    public String generateImageUrl(int withKey) {

        String urlPrefix = "";
        String urlSuffix = "";
        String url = "";

        switch (vendor) {

            case VENDOR_TAMIYA:
                int skuInt = new Integer(sku).intValue();
                //ACRYLIC GLOSS
                if (skuInt > 81000 & skuInt < 81301) {
                    urlPrefix = IMG_URL_TAMIYA_ACR_GLOSS_PREFIX;
                    urlSuffix = IMG_URL_TAMIYA_SUFFIX;
                }
                //ACRYLIC FLAT
                if (skuInt > 81300 & skuInt < 81372) {
                    urlPrefix = IMG_URL_TAMIYA_ACR_FLAT_PREFIX;
                    urlSuffix = IMG_URL_TAMIYA_SUFFIX;
                }
                //ENAMEL GLOSS
                if (skuInt > 80000 & skuInt < 80041) {
                    urlPrefix = IMG_URL_TAMIYA_ENML_GLOSS_PREFIX;
                    urlSuffix = IMG_URL_TAMIYA_SUFFIX;
                }
                //ENAMEL FLAT
                if (skuInt > 80300 & skuInt < 80386) {
                    urlPrefix = IMG_URL_TAMIYA_ENML_FLAT_PREFIX;
                    urlSuffix = IMG_URL_TAMIYA_SUFFIX;
                }
                //Airmodel Spray
                if (skuInt > 86500 & skuInt < 86533) {
                    urlPrefix = IMG_URL_TAMIYA_AIRMODELSPRAY_PREFIX;
                    urlSuffix = IMG_URL_TAMIYA_SUFFIX;
                }
                //Spray
                if (skuInt > 85000 & skuInt < 85102) {
                    urlPrefix = IMG_URL_TAMIYA_SPRAY_PREFIX;
                    urlSuffix = IMG_URL_TAMIYA_SUFFIX;
                }
                break;
            case VENDOR_MRHOBBY:
                urlPrefix = IMG_URL_MRHOBBY_PREFIX;
                urlSuffix = IMG_URL_MRHOBBY_SUFFIX;
                break;
            case VENDOR_HUMBROL:
                urlPrefix = IMG_URL_HUMBROL_PREFIX;
                urlSuffix = IMG_URL_HUMBROL_SUFFIX;
                break;

        }

        switch (withKey) {
            case VendorPaint.SKU:
                url = urlPrefix + sku + urlSuffix;
                break;
            case VendorPaint.CODE:
                url = urlPrefix + code + urlSuffix;
                break;
        }

        return url;

    }

}