<!-- change html to jsp
1 page 
2 use el jstl
3 change .jsp
  -->
  
<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>Gallery</title>
    <link rel="stylesheet" type="text/css" href="css/css1.css" />
    <script type="text/javascript" src="js/js1.js"></script>
  </head>
  <body>
  	<!-- 用内置函数param 来获取当前request 的参数 -->
  	<c:if test="${param.c != null}">
  		<c:set var="categoryParam" value="&c=${param.c}"></c:set>
  	</c:if>
  	<c:if test="${param.c == null}">
  		<c:set var="categoryParam" value=""></c:set>
  	</c:if>
    <div class="header">
      <div class="logo">
        <img  src="image/logo.PNG"  />
      </div>
      <!-- 注意click的位置 -->
      <div class="menu" onmouseleave="closeMenu()" >
        <div class="menu_title" onclick="showMenu()">
          <!-- 超级链接不能为“” #表示本页 -->
          <a href="#">category</a>
        </div>

        <ul id="menuId">
          <li><a href="pc?c=1">realism</a></li>
          <li><a href="pc?c=2">abstractionism</a></li>
        </ul>
      </div>
      <div class="auth">
        <ul>
          <li>
            <!-- ### 停留在单击的位置 -->
            <a href="#">signin</a>
          </li>
          <li>
            <a href="#">singup</a>
          </li>
        </ul>
      </div>


    </div>
    <div class="content">
      <div class="banner">
        <img src="image/banner.PNG" class="banner-image" height="280" width="1200"/>
      </div>
      <div class="content-img">
         <ul>
         <!-- items 表示来源，  var表示后续变量 -->
           <c:forEach items="${pageModel.pageData}" var="painting">
           <li>
             <img src="${painting.preview}" class="goods" height="280" width="280"/>
             <div class="goods_info">
               <h3>${painting.pname}</h3>
               <p>
                 ${painting.descrption}
               </p>
               <div class="price_cart">
                 <div class="price">$<fmt:formatNumber pattern="0.00" value="${painting.price}"></fmt:formatNumber></div>
                 <div class="cart">
                     <a href=# class="class_link">
                       <img src="image/cart.PNG" />
                     </a>
                 </div>
               </div>
             </div>
           </li>
           </c:forEach>
         </ul>
      </div>
      <div class="page-nav">
        <ul>
          <li><a href="pc?p=1">head</a></li>
          <li><a href="pc?p=${pageModel.hasPreviousPage?pageModel.page-1:1}${categoryParam}">previous</a></li>
		  <c:forEach begin="1" end="${pageModel.totalPages}" var="pno" step="1">
		  	<li><span ${pno==pageModel.page?"class='first'":""}>
		  		<a href="pc?p=${pno}${categoryParam}">
		  		${pno}
		  		</a>
		  	</span></li>
		  
		  </c:forEach>
          

          <li><a href="pc?p=${pageModel.hasNextPage?pageModel.page+1:pageModel.totalPages}${categoryParam}">next</a></li>
          <li><a href="pc?p=${pageModel.totalPages}">tail</a></li>
        </ul>
      </div>
    </div>
    <div class="footer">
      <p><span>GALLERY</span> 2017 POWERED BY DI</p>
    </div>

  </body>
</html>
