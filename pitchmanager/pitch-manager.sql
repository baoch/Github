USE [master]
GO
/****** Object:  Database [PitchManager]    Script Date: 5/27/2017 12:11:19 AM ******/
CREATE DATABASE [PitchManager]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'PitchManager', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL13.SQLEXPRESS\MSSQL\DATA\PitchManager.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'PitchManager_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL13.SQLEXPRESS\MSSQL\DATA\PitchManager_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [PitchManager] SET COMPATIBILITY_LEVEL = 130
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [PitchManager].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [PitchManager] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [PitchManager] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [PitchManager] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [PitchManager] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [PitchManager] SET ARITHABORT OFF 
GO
ALTER DATABASE [PitchManager] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [PitchManager] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [PitchManager] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [PitchManager] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [PitchManager] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [PitchManager] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [PitchManager] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [PitchManager] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [PitchManager] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [PitchManager] SET  DISABLE_BROKER 
GO
ALTER DATABASE [PitchManager] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [PitchManager] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [PitchManager] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [PitchManager] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [PitchManager] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [PitchManager] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [PitchManager] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [PitchManager] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [PitchManager] SET  MULTI_USER 
GO
ALTER DATABASE [PitchManager] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [PitchManager] SET DB_CHAINING OFF 
GO
ALTER DATABASE [PitchManager] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [PitchManager] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [PitchManager] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [PitchManager] SET QUERY_STORE = OFF
GO
USE [PitchManager]
GO
ALTER DATABASE SCOPED CONFIGURATION SET LEGACY_CARDINALITY_ESTIMATION = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET LEGACY_CARDINALITY_ESTIMATION = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET MAXDOP = 0;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET MAXDOP = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET PARAMETER_SNIFFING = ON;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET PARAMETER_SNIFFING = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET QUERY_OPTIMIZER_HOTFIXES = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET QUERY_OPTIMIZER_HOTFIXES = PRIMARY;
GO
USE [PitchManager]
GO
/****** Object:  Table [dbo].[tblAccount]    Script Date: 5/27/2017 12:11:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblAccount](
	[accountId] [int] IDENTITY(1,1) NOT NULL,
	[username] [nvarchar](20) NOT NULL,
	[password] [nvarchar](20) NOT NULL,
	[roleId] [int] NOT NULL,
	[isDeleted] [bit] NOT NULL,
	[isDeactivated] [bit] NOT NULL,
 CONSTRAINT [PK_tblAccount] PRIMARY KEY CLUSTERED 
(
	[accountId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblBill]    Script Date: 5/27/2017 12:11:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblBill](
	[billId] [int] IDENTITY(1,1) NOT NULL,
	[customerId] [int] NOT NULL,
	[isFullyPaid] [bit] NOT NULL,
	[currentlyPaid] [float] NOT NULL,
	[currentlyDebt] [float] NOT NULL,
	[lastPayoutDate] [date] NULL,
	[totalPrice] [float] NOT NULL,
 CONSTRAINT [PK_tblPitchReservation] PRIMARY KEY CLUSTERED 
(
	[billId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblBillPayment]    Script Date: 5/27/2017 12:11:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblBillPayment](
	[paymentId] [int] IDENTITY(1,1) NOT NULL,
	[billId] [int] NOT NULL,
	[payoutNum] [int] NOT NULL,
	[payoutValue] [float] NOT NULL,
	[payoutDate] [date] NOT NULL,
 CONSTRAINT [PK_tblBillPayment] PRIMARY KEY CLUSTERED 
(
	[paymentId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblCustomer]    Script Date: 5/27/2017 12:11:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblCustomer](
	[customerId] [int] IDENTITY(1,1) NOT NULL,
	[fullname] [nvarchar](50) NOT NULL,
	[phone] [nvarchar](20) NOT NULL,
 CONSTRAINT [PK_tblCustomer] PRIMARY KEY CLUSTERED 
(
	[customerId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblPitch]    Script Date: 5/27/2017 12:11:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblPitch](
	[pitchId] [int] IDENTITY(1,1) NOT NULL,
	[pitchName] [nvarchar](50) NOT NULL,
	[pitchTypeId] [int] NOT NULL,
	[pitchWidth] [float] NOT NULL,
	[pitchLength] [float] NOT NULL,
	[status] [bit] NOT NULL,
 CONSTRAINT [PK_tblPitch] PRIMARY KEY CLUSTERED 
(
	[pitchId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblPitchType]    Script Date: 5/27/2017 12:11:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblPitchType](
	[pitchTypeId] [int] IDENTITY(1,1) NOT NULL,
	[pitchTypeName] [nvarchar](50) NOT NULL,
	[maxPlayers] [int] NOT NULL,
	[roundSlot] [int] NOT NULL,
 CONSTRAINT [PK_tblPitchType] PRIMARY KEY CLUSTERED 
(
	[pitchTypeId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblRole]    Script Date: 5/27/2017 12:11:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblRole](
	[roleId] [int] IDENTITY(1,1) NOT NULL,
	[roleName] [nvarchar](20) NOT NULL,
 CONSTRAINT [PK_tblRole] PRIMARY KEY CLUSTERED 
(
	[roleId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblSlot]    Script Date: 5/27/2017 12:11:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblSlot](
	[slotId] [int] NOT NULL,
	[fromTime] [time](7) NOT NULL,
	[toTime] [time](7) NOT NULL,
 CONSTRAINT [PK_tblSlot] PRIMARY KEY CLUSTERED 
(
	[slotId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblSlotReserve]    Script Date: 5/27/2017 12:11:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblSlotReserve](
	[slotReserveId] [int] IDENTITY(1,1) NOT NULL,
	[slotId] [int] NOT NULL,
	[pitchId] [int] NOT NULL,
	[price] [float] NULL,
	[date] [date] NOT NULL,
	[billId] [int] NOT NULL,
 CONSTRAINT [PK_tblSlotReserve] PRIMARY KEY CLUSTERED 
(
	[slotReserveId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblTimeFrame]    Script Date: 5/27/2017 12:11:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblTimeFrame](
	[timeFrameId] [int] IDENTITY(1,1) NOT NULL,
	[fromTime] [time](7) NOT NULL,
	[toTime] [time](7) NOT NULL,
 CONSTRAINT [PK_tblTimeFrame] PRIMARY KEY CLUSTERED 
(
	[timeFrameId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblTimeFrame_PitchType]    Script Date: 5/27/2017 12:11:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblTimeFrame_PitchType](
	[pitchTypeId] [int] NOT NULL,
	[timeFrameId] [int] NOT NULL,
	[referencePrice] [float] NOT NULL
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[tblAccount]  WITH CHECK ADD  CONSTRAINT [FK_tblAccount_tblRole] FOREIGN KEY([roleId])
REFERENCES [dbo].[tblRole] ([roleId])
GO
ALTER TABLE [dbo].[tblAccount] CHECK CONSTRAINT [FK_tblAccount_tblRole]
GO
ALTER TABLE [dbo].[tblBill]  WITH CHECK ADD  CONSTRAINT [FK_tblPitchReservation_tblCustomer] FOREIGN KEY([customerId])
REFERENCES [dbo].[tblCustomer] ([customerId])
GO
ALTER TABLE [dbo].[tblBill] CHECK CONSTRAINT [FK_tblPitchReservation_tblCustomer]
GO
ALTER TABLE [dbo].[tblBillPayment]  WITH CHECK ADD  CONSTRAINT [FK_tblReservePayout_tblPitchReservation] FOREIGN KEY([billId])
REFERENCES [dbo].[tblBill] ([billId])
GO
ALTER TABLE [dbo].[tblBillPayment] CHECK CONSTRAINT [FK_tblReservePayout_tblPitchReservation]
GO
ALTER TABLE [dbo].[tblPitch]  WITH CHECK ADD  CONSTRAINT [FK_tblPitch_tblPitchType] FOREIGN KEY([pitchTypeId])
REFERENCES [dbo].[tblPitchType] ([pitchTypeId])
GO
ALTER TABLE [dbo].[tblPitch] CHECK CONSTRAINT [FK_tblPitch_tblPitchType]
GO
ALTER TABLE [dbo].[tblSlotReserve]  WITH CHECK ADD  CONSTRAINT [FK_tblSlotReserve_tblBill] FOREIGN KEY([billId])
REFERENCES [dbo].[tblBill] ([billId])
GO
ALTER TABLE [dbo].[tblSlotReserve] CHECK CONSTRAINT [FK_tblSlotReserve_tblBill]
GO
ALTER TABLE [dbo].[tblSlotReserve]  WITH CHECK ADD  CONSTRAINT [FK_tblSlotReserve_tblPitch] FOREIGN KEY([pitchId])
REFERENCES [dbo].[tblPitch] ([pitchId])
GO
ALTER TABLE [dbo].[tblSlotReserve] CHECK CONSTRAINT [FK_tblSlotReserve_tblPitch]
GO
ALTER TABLE [dbo].[tblSlotReserve]  WITH CHECK ADD  CONSTRAINT [FK_tblSlotReserve_tblSlot] FOREIGN KEY([slotId])
REFERENCES [dbo].[tblSlot] ([slotId])
GO
ALTER TABLE [dbo].[tblSlotReserve] CHECK CONSTRAINT [FK_tblSlotReserve_tblSlot]
GO
ALTER TABLE [dbo].[tblTimeFrame_PitchType]  WITH CHECK ADD  CONSTRAINT [FK_tblTimeFrame_PitchType_tblPitchType] FOREIGN KEY([pitchTypeId])
REFERENCES [dbo].[tblPitchType] ([pitchTypeId])
GO
ALTER TABLE [dbo].[tblTimeFrame_PitchType] CHECK CONSTRAINT [FK_tblTimeFrame_PitchType_tblPitchType]
GO
ALTER TABLE [dbo].[tblTimeFrame_PitchType]  WITH CHECK ADD  CONSTRAINT [FK_tblTimeFrame_PitchType_tblTimeFrame] FOREIGN KEY([timeFrameId])
REFERENCES [dbo].[tblTimeFrame] ([timeFrameId])
GO
ALTER TABLE [dbo].[tblTimeFrame_PitchType] CHECK CONSTRAINT [FK_tblTimeFrame_PitchType_tblTimeFrame]
GO
USE [master]
GO
ALTER DATABASE [PitchManager] SET  READ_WRITE 
GO
