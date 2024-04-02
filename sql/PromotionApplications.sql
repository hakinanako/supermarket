CREATE TABLE PromotionApplications (
                                       ApplicationID INT AUTO_INCREMENT PRIMARY KEY, -- 应用范围的唯一标识符
                                       PromotionID INT, -- 关联的优惠活动ID
                                       TargetType VARCHAR(50), -- 应用目标类型，如"SKU", "SPU", "ORDER", "MEMBER"
                                       TargetID INT, -- 目标ID，根据TargetType不同，这里可以是SKU_ID、SPU_ID、订单ID或会员ID
                                       Remark TEXT, -- 备注信息
                                       IsDeleted TINYINT DEFAULT 0 -- 标记是否删除，0表示未删除，1表示已删除
);
