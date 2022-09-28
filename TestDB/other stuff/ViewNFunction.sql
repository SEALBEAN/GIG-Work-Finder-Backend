GO
CREATE VIEW VW_Province
AS
SELECT DISTINCT Province FROM Location
GO

--In ra các tỉnh ưu tiên HCM và HN
GO
SELECT * FROM VW_Province
ORDER BY 
	(CASE WHEN Province = N'Thành phố Hồ Chí Minh' then 1
		  WHEN Province = N'Thành phố Hà Nội' then 2 else 3 end), Province
GO
GO
--Hàm liệt kê các huyện của tỉnh đc truyền vào
CREATE FUNCTION FN_ListCity(@Pro nvarchar(255))
RETURNS TABLE
AS
RETURN 
	SELECT City FROM Location
	WHERE Province LIKE @Pro
GO

CREATE FUNCTION FN_TotalOfReviews(@Id int)
RETURNS int
AS
BEGIN
RETURN
	(SELECT COUNT(*) FROM ReviewDetail
	WHERE AccountID = @Id AND Status = 1)
END
GO

CREATE FUNCTION FN_AverageStars(@Id int, @NumOfRev int)
RETURNS float
AS
BEGIN
RETURN
	(CAST((SELECT SUM(Stars) FROM ReviewDetail 
	WHERE AccountID = @Id AND Status = 1) AS float) / CAST (@NumOfRev AS float))
END
GO
