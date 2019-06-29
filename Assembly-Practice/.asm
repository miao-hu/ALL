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
code    ends
        end begin
 
 

2.要求在数据段定义一个dw类型的数据，编写程序将其以十六进制形式在屏幕上显示。

data    segment
dat1    dw      255
data    ends

code    segment
        assume cs:code,ds:data
begin:
        mov ax,data
        mov ds,ax

        mov bx,dat1
        mov cx,4

t:      push cx
        mov cl,4
        rol bx,cl
        pop cx
        mov dl,bl
        and dl,0fh
        add dl,30h
        cmp dl,39h
        jbe print
        add dl,7
print:  mov ah,2
        int 21h
        loop t

        mov ah,4ch
        int 21h
code    ends
        end begin
      
      
        
3. 要求在数据段定义一个dw类型的数据，编写程序将其以十进制形式在屏幕上显示。 

data    segment
dat1    dw     0ffffh
data    ends

code    segment
        assume cs:code,ds:data
begin:
        mov ax,data
        mov ds,ax

        mov bx,dat1
        mov cx,10000
        call dec_div
        mov cx,1000
        call dec_div
        mov cx,100
        call dec_div
        mov cx,10
        call dec_div
        mov cx,1
        call dec_div
        
        mov ah,4ch
        int 21h

dec_div proc
        mov dx,0
        mov ax,bx
        div cx
        mov bx,dx
        mov dl,al
        add dl,30h
        mov ah,2
        int 21h
        ret
dec_div endp
code    ends
        end begin





