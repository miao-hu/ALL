1.要求在数据段定义一个dw类型的数据，编写程序将其以二进制形式在屏幕上显示。

data    segment
dat1    dw      5678h
data    ends

code    segment
        assume cs:code,ds:data
begin:
        mov ax,data
        mov ds,ax

        mov bx,dat1
        mov cx,16

t:      rol bx,1
        mov dl,bl
        and dl,01h
        add dl,30h
        mov ah,2
        int 21h
        loop t

        mov ah,4ch
        int 21h
code ends
     end begin
