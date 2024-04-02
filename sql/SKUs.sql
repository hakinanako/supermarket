CREATE TABLE SKUs (
                      SKU_ID INT AUTO_INCREMENT PRIMARY KEY, -- SKU的唯一标识符
                      SPU_ID INT, -- 关联的SPU的ID
                      SKU_Name VARCHAR(255) NOT NULL, -- SKU的具体名称，可能包含颜色、尺寸等信息
                      Attributes TEXT, -- SKU的属性，如颜色、尺寸等，存储为JSON或其他结构化格式
                      Price DECIMAL(10, 2) NOT NULL, -- SKU的售价
                      StockQuantity INT, -- SKU的库存数量
                      ImageURL VARCHAR(255), -- SKU的图片URL
                      Remark TEXT, -- 备注信息
                      IsDeleted TINYINT DEFAULT 0 -- 标记是否删除，0表示未删除，1表示已删除
);
