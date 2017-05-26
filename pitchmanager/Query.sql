
--Get startSlot and end Slot of a reservation
Select sl.* 
From tblSlot sl,(
	Select Min(t.slotId) As 'fromSlot', Max(t.slotId) As 'toSlot' 
	From (
		Select s.slotId 
		from tblSlotReserve s where billId = 25) t) m  
where slotId = fromSlot Or slotId = toSlot 

--Insert payment and re-calculate the debt



-- Update a customer if existed or insert a new customer
Begin tran
	IF EXISTS (SELECT * from tblCustomer where phone = '01682301813')
		begin
			Update tblCustomer set fullname = 'Viet Quoc Hoang' where phone = '01682301813'
		end 
	ELSE
		begin 
			Insert into tblCustomer (fullname, phone) values('Viet Quoc Hoang', '01682301813')
		end 
commit tran 