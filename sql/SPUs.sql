CREATE TABLE spu (
                      SPU_ID INT AUTO_INCREMENT PRIMARY KEY, -- SPU的唯一标识符
                      Name VARCHAR(255) NOT NULL, -- 商品的通用名称
                      Category VARCHAR(100), -- 商品所属的类别
                      Brand VARCHAR(100), -- 商品的品牌
                      Description TEXT, -- 商品的详细描述
                      Remark TEXT, -- 备注信息
                      IsDeleted TINYINT DEFAULT 0 -- 标记是否删除，0表示未删除，1表示已删除
);
