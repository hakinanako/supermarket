CREATE TABLE members (
                         MemberID INT AUTO_INCREMENT PRIMARY KEY, -- 会员的唯一标识符
                         Name VARCHAR(255) NOT NULL, -- 会员姓名
                         Email VARCHAR(100), -- 会员邮箱，用于联系和发送通知
                         PhoneNumber VARCHAR(20), -- 会员的联系电话
                         RegistrationDate DATETIME, -- 会员注册时间
                         MemberLevel VARCHAR(50), -- 会员等级
                         Remark TEXT, -- 备注信息，可以用于存储会员的特殊需求或其他注释
                         IsDeleted TINYINT DEFAULT 0 -- 标记是否删除，0表示未删除，1表示已删除
);
