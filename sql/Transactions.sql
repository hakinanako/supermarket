CREATE TABLE Transactions (
                              TransactionID INT AUTO_INCREMENT PRIMARY KEY, -- 交易的唯一标识符，每笔交易一个唯一ID
                              TotalAmount DECIMAL(10, 2), -- 该笔交易的总金额
                              TransactionDate DATETIME, -- 交易发生的日期和时间
                              Balance DECIMAL(10, 2), -- 交易后的余额，反映了交易对总账户余额的影响
                              EmployeeID INT, -- 处理该交易的员工ID
                              Remark TEXT, -- 交易相关的备注信息
                              IsDeleted TINYINT DEFAULT 0 -- 用于软删除标记，0表示未删除，1表示已删除
);
