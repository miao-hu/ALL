# coding : utf-8
from selenium import webdriver      # 导入 webdriver ,相当于加载了 webdriver 里面所有的方法

driver = webdriver.Chrome()         # 创建 chrome 对象
driver.get("https://baike.baidu.com/item/%E8%A5%BF%E5%AE%89/121614?fr=aladdin")     # 在 chrmoe 中输入要访问的 url 路径（西安）
driver.quit()                       # 关闭 chrmoe 对象
