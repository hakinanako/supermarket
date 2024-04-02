CREATE TABLE Products (
                          ProductID INT AUTO_INCREMENT PRIMARY KEY, -- 产品的唯一标识符
                          SKU_ID INT, -- 关联的SKU的ID
                          SPU_ID INT, -- 关联的SPU的ID
                          Remark TEXT, -- 备注信息
                          IsDeleted TINYINT DEFAULT 0 -- 标记是否删除，0表示未删除，1表示已删除
);
