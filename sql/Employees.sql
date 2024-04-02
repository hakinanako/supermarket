CREATE TABLE Employees (
                           EmployeeID INT AUTO_INCREMENT PRIMARY KEY, -- 员工的唯一标识符
                           Name VARCHAR(255) NOT NULL, -- 员工姓名
                           Position VARCHAR(100), -- 员工职位
                           Email VARCHAR(100), -- 员工邮箱，用于工作相关通信
                           PhoneNumber VARCHAR(20), -- 员工的联系电话
                           HireDate DATETIME, -- 入职日期
                           Remark TEXT, -- 备注信息，可以用于记录员工的特殊情况或其他重要信息
                           IsDeleted TINYINT DEFAULT 0 -- 标记是否删除，0表示未删除，1表示已删除
);
