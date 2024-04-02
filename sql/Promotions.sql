CREATE TABLE Promotions (
                            PromotionID INT AUTO_INCREMENT PRIMARY KEY, -- 优惠活动的唯一标识符
                            Name VARCHAR(255) NOT NULL, -- 优惠活动名称
                            Description TEXT, -- 优惠活动描述
                            StartDate DATETIME, -- 活动开始时间
                            EndDate DATETIME, -- 活动结束时间
                            IsActive TINYINT DEFAULT 1, -- 活动是否激活，1为激活，0为非激活
                            Remark TEXT, -- 备注信息
                            IsDeleted TINYINT DEFAULT 0 -- 标记是否删除，0表示未删除，1表示已删除
);
