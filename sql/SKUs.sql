CREATE TABLE orders (
                        OrderID INT AUTO_INCREMENT PRIMARY KEY, -- 订单的唯一标识符
                        TransactionID INT, -- 关联的交易ID
                        EmployeeID INT, -- 处理该订单的员工ID
                        OrderDate DATETIME, -- 订单日期和时间
                        TotalAmount DECIMAL(10, 2), -- 订单的总金额
                        Remark TEXT, -- 订单相关的备注信息
                        IsDeleted TINYINT DEFAULT 0 -- 用于软删除标记，0表示未删除，1表示已删除
);

CREATE TABLE order_details (
                              OrderDetailID INT AUTO_INCREMENT PRIMARY KEY, -- 订单详情的唯一标识符
                              OrderID INT, -- 关联的订单ID
                              SKU_ID INT, -- 关联的SKU的ID
                              Quantity INT, -- SKU的数量
                              Price DECIMAL(10, 2), -- SKU的单价
                              Subtotal DECIMAL(10, 2), -- 小计金额（SKU的单价 * 数量）
                              Remark TEXT, -- 订单详情相关的备注信息
                              IsDeleted TINYINT DEFAULT 0 -- 用于软删除标记，0表示未删除，1表示已删除
);