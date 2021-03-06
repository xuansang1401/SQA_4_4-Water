USE [master]
GO
/****** Object:  Database [TienNuoc]    Script Date: 4/24/2021 8:01:32 PM ******/
CREATE DATABASE [TienNuoc]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'TienNuoc', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\TienNuoc.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'TienNuoc_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\TienNuoc_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [TienNuoc] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [TienNuoc].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [TienNuoc] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [TienNuoc] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [TienNuoc] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [TienNuoc] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [TienNuoc] SET ARITHABORT OFF 
GO
ALTER DATABASE [TienNuoc] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [TienNuoc] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [TienNuoc] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [TienNuoc] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [TienNuoc] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [TienNuoc] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [TienNuoc] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [TienNuoc] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [TienNuoc] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [TienNuoc] SET  DISABLE_BROKER 
GO
ALTER DATABASE [TienNuoc] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [TienNuoc] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [TienNuoc] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [TienNuoc] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [TienNuoc] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [TienNuoc] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [TienNuoc] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [TienNuoc] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [TienNuoc] SET  MULTI_USER 
GO
ALTER DATABASE [TienNuoc] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [TienNuoc] SET DB_CHAINING OFF 
GO
ALTER DATABASE [TienNuoc] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [TienNuoc] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [TienNuoc] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [TienNuoc] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [TienNuoc] SET QUERY_STORE = OFF
GO
USE [TienNuoc]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 4/24/2021 8:01:32 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[FullName] [varchar](50) NOT NULL,
	[Email] [varchar](50) NOT NULL,
	[Adress] [varchar](50) NOT NULL,
	[Phone] [varchar](50) NOT NULL,
	[NumberWater] [int] NOT NULL,
	[TotalMoney] [float] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Users] ON 

INSERT [dbo].[Users] ([id], [FullName], [Email], [Adress], [Phone], [NumberWater], [TotalMoney]) VALUES (17, N'thai', N'thai@gmail.com', N'cau den', N'456723', 30, 150000)
INSERT [dbo].[Users] ([id], [FullName], [Email], [Adress], [Phone], [NumberWater], [TotalMoney]) VALUES (18, N'tuyen', N'tuyen@gmail.com', N'ha dong', N'0987654', 20, 100000)
INSERT [dbo].[Users] ([id], [FullName], [Email], [Adress], [Phone], [NumberWater], [TotalMoney]) VALUES (19, N'3', N'323@gmail.com', N'3', N'3', 3, 3)
INSERT [dbo].[Users] ([id], [FullName], [Email], [Adress], [Phone], [NumberWater], [TotalMoney]) VALUES (20, N'thai1', N'thai1@gmail.com', N'avaksdnv', N'1234567', 15, 75000)
INSERT [dbo].[Users] ([id], [FullName], [Email], [Adress], [Phone], [NumberWater], [TotalMoney]) VALUES (21, N'thanh', N'thanh@gmail.com', N'trang viet', N'124445555', 10, 50000)
INSERT [dbo].[Users] ([id], [FullName], [Email], [Adress], [Phone], [NumberWater], [TotalMoney]) VALUES (22, N'minh ', N'minh@gmail.com', N'dan phuong', N'11111111', 11, 55000)
SET IDENTITY_INSERT [dbo].[Users] OFF
GO
USE [master]
GO
ALTER DATABASE [TienNuoc] SET  READ_WRITE 
GO
