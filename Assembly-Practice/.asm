1.要求在数据段定义一个dw类型的数据，编写程序将其以二进制形式在屏幕上显示。

data    segment        //数据段
dat1    dw      5678h
data    ends

code    segment        //代码段
        assume cs:code,ds:data
begin:
        mov ax,data
        mov ds,ax

        mov bx,dat1
        mov cx,16     //dw类型16位，CX循环次数

t:      rol bx,1
        mov dl,bl
        and dl,01h
        add dl,30h
        mov ah,2
        int 21h
        loop t        //循环

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



4.将上述3个程序功能：（要求在数据段定义一个dw类型的数据，编写程序将其以二进制形式在屏幕上显示
		     要求在数据段定义一个dw类型的数据，编写程序将其以十六进制形式在屏幕上显示
		     要求在数据段定义一个dw类型的数据，编写程序将其以十六进制形式在屏幕上显示）

		   改写成子程序，在主程序中调用，实现将定义的dw类型数据，分别以二进制、十六进制、十进制形式在屏幕上显示输出。

data    segment
dat1    dw     0ffffh
data    ends

code    segment
        assume cs:code,ds:data
begin:
        mov ax,data
        mov ds,ax

	call bin_show    //2进制
	call hex_show    //16进制
	call dec_show    //10进制

	mov ah,4ch     //返回操作系统
        int 21h

hex_show proc     //子程序
        mov bx,dat1
        mov cx,4

t2:     push cx
        mov cl,4
        rol bx,cl
        pop cx
        mov dl,bl
        and dl,0fh
        add dl,30h
        cmp dl,39h
        jbe print
        add dl,7
print:  mov ah,2   //显示字符
        int 21h
        loop t2
	ret
hex_show endp

bin_show proc      //子程序
        mov bx,dat1
        mov cx,16

t1:     rol bx,1
        mov dl,bl
        and dl,01h
        add dl,30h
        mov ah,2  //显示字符
        int 21h
        loop t1
	ret
bin_show endp

dec_show proc
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
	ret
dec_show endp
        
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



5.改写程序四，增加功能：统计该数据二进制表示形式中“1”的个数并显示。

data    segment
dat1    dw     0ffffh
cn      dw		?    //统计个数
data    ends

code    segment
        assume cs:code,ds:data
begin:
        mov ax,data
        mov ds,ax

	mov bx,dat1
	call bin_show
	call crlf

	mov bx,dat1
	call hex_show
	call crlf

	mov bx,dat1
	call dec_show
    	call crlf

	call count1
	mov bx,cn
	call dec_show

	mov ah,4ch
       	int 21h

hex_show proc
        mov cx,4

t2:     push cx
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
        loop t2
	ret
hex_show endp

bin_show proc
        mov cx,16

t1:     rol bx,1
        mov dl,bl
        and dl,01h
        add dl,30h
        mov ah,2
        int 21h
        loop t1
		ret
bin_show endp

dec_show proc
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
	ret
dec_show endp
        
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

count1	proc
	mov dx,0
	mov bx,dat1
	mov cx,16
t:      shl bx,1
	jnc next
	inc dx
next:   loop t
	mov cn,dx
	ret
count1	endp

crlf	proc
        mov dl,0dh
	mov ah,2
	int 21h
	mov dl,0ah
	mov ah,2
	int 21h
	ret
crlf	endp

code    ends
        end begin
 
 
 
 6.十进制数显示程序：要求在数据段定义一个dw类型的数据，编写程序将其以十进制形式在屏幕上显示。
 		    以实际位数在屏幕显示十进制数（去掉前面多余的0）。
 
data    segment
dat1    dw		502
flag    dw     ?
data    ends

code    segment
        assume cs:code,ds:data
begin:
        mov ax,data
        mov ds,ax

	mov bx,dat1
	call dec_show
		
	mov ah,4ch
        int 21h



dec_show proc
        push cx
	mov flag,1
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
	pop cx
	ret
dec_show endp
        
    
dec_div proc
        mov dx,0
        mov ax,bx
        div cx
        mov bx,dx
        mov dl,al
	cmp dl,0
	jnz print
	cmp flag,1
	jz  exit
print:  add dl,30h
        mov ah,2
        int 21h
	mov flag,0
exit:   ret
dec_div endp

code 	ends
        end begin



7.十进制数显示程序：要求在数据段定义一个dw类型的数据，编写程序将其以十进制形式在屏幕上显示。
		   以带符号数形式显示十进制数。
		  
data    segment
dat1    dw     -20180
flag    dw     ?
data    ends

code    segment
        assume cs:code,ds:data
begin:
        mov ax,data
        mov ds,ax

	mov bx,dat1
	call f_dec_show

	mov ah,4ch
        int 21h

f_dec_show proc
	and bx,bx
	jns show
	mov dl,'-'
	mov ah,2
	int 21h
	neg bx
show:	call dec_show
	ret
f_dec_show endp

dec_show proc
        push cx
	mov flag,1
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
	pop cx
	ret
dec_show endp
        
    
dec_div proc
        mov dx,0
        mov ax,bx
        div cx
        mov bx,dx
        mov dl,al
	cmp dl,0
	jnz print
	cmp flag,1
	jz  exit
print:  add dl,30h
        mov ah,2
        int 21h
	mov flag,0
exit:   ret
dec_div endp

code 	ends
    	end begin

 
8.在数据段定义一个数组，其中存放若干个dw类型数据，编写程序将数组中元素以十进制形式显示。

data    segment
arr	dw     37,-280,3100,6,-92,427,502,30024,-6305,-883
n       dw     10
flag    dw     ?
data    ends

code    segment
        assume cs:code,ds:data
begin:
        mov ax,data
        mov ds,ax

	call arr_show		

	mov ah,4ch
        int 21h

arr_show proc
        lea si,arr
	mov cx,n
t:	mov bx,[si]
	call f_dec_show
	call space_show
	add si,2
	loop t 
        ret
arr_show endp

f_dec_show proc
	and bx,bx
	jns show
	mov dl,'-'
	mov ah,2
	int 21h
	neg bx
show:	call dec_show
	ret
f_dec_show endp

dec_show proc
        push cx
	mov flag,1
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
	pop cx
	ret
dec_show endp
        
    
dec_div proc
        mov dx,0
        mov ax,bx
        div cx
        mov bx,dx
        mov dl,al
	cmp dl,0
	jnz print
	cmp flag,1
	jz  exit
print:  add dl,30h
        mov ah,2
        int 21h
	mov flag,0
exit:   ret
dec_div endp

space_show	proc
        mov dl,20h
	mov ah,2
	int 21h
	ret
space_show	endp
code 	ends
    	end begin
