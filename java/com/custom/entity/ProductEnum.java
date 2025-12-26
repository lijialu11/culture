package com.custom.entity;

/**
 * 文创产品枚举类
 */
public class ProductEnum {
    // 产品类型
    public static final String[] PRODUCT_TYPES = {"书签", "保温杯", "冰箱贴", "帆布袋", "海报", "折扇"};

    // 尺寸（按产品类型分类）
    public static final String[][] SIZES = {
            {"小号", "中号", "大号"}, // 书签
            {"300ml", "500ml", "750ml"}, // 保温杯
            {"3cm×3cm", "5cm×5cm", "8cm×8cm"}, // 冰箱贴
            {"小号(30×40cm)", "中号(40×50cm)", "大号(50×60cm)"}, // 帆布袋
            {"A4", "A3", "A2"}, // 海报
            {"8寸", "10寸", "12寸"} // 折扇
    };

    // 材质（按产品类型分类）
    public static final String[][] MATERIALS = {
            {"铜版纸", "牛皮纸", "特种纸"}, // 书签
            {"304不锈钢", "陶瓷", "玻璃"}, // 保温杯
            {"软磁贴", "硬磁贴", "亚克力"}, // 冰箱贴
            {"纯棉", "帆布", "牛津布"}, // 帆布袋
            {"铜版纸", "相纸", "油画布"}, // 海报
            {"宣纸", "绢布", "竹制"} // 折扇
    };

    // 根据产品类型索引获取对应尺寸
    public static String[] getSizesByType(int typeIndex) {
        return SIZES[typeIndex];
    }

    // 根据产品类型索引获取对应材质
    public static String[] getMaterialsByType(int typeIndex) {
        return MATERIALS[typeIndex];
    }
}
