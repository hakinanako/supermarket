CREATE TABLE PromotionRules (
                                RuleID INT AUTO_INCREMENT PRIMARY KEY, -- 优惠规则的唯一标识符
                                PromotionID INT, -- 关联的优惠活动ID
                                RuleType VARCHAR(50), -- 规则类型，如"DISCOUNT", "FULL_REDUCTION", "GIFT"
                                RuleDetail TEXT, -- 规则详细信息，根据不同类型的规则，这里可以存储JSON格式的详细数据，考虑正则等等
                                Remark TEXT, -- 备注信息
                                IsDeleted TINYINT DEFAULT 0 -- 标记是否删除，0表示未删除，1表示已删除
);
