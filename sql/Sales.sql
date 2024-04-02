CREATE TABLE Sales (
                       SaleID INT AUTO_INCREMENT PRIMARY KEY, -- 销售记录的唯一标识符
                       TransactionID INT, -- 关联的交易ID，指向Transactions表的TransactionID
                       SKU_ID INT, -- 销售商品的SKU ID
                       QuantitySold INT, -- 在该笔交易中售出的数量
                       SalePrice DECIMAL(10, 2), -- 商品的销售价格
                       Remark TEXT, -- 销售相关的备注信息
                       IsDeleted TINYINT DEFAULT 0 -- 用于软删除标记，0表示未删除，1表示已删除
);
