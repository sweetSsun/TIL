<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>

<!DOCTYPE html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>관리자 - 스케줄 등록</title>

  	<%@ include file="/WEB-INF/views/includes/commonCss.jsp" %>
  	
  	<style type="text/css">
	  	.radiobtn input[type=radio]{
	  	 	 display: none;
		}
  		.radiobtn input[type=radio]+label{
    		background-color: #fff;
    		color: #333;
    		cursor: pointer;
 			height: 25px;
 		    width: 25px;
 		    border: 1px solid #333;
 		    text-align: center;
 		    border-radius: 5px;
		}
		.radiobtn input[type=radio]:checked+label{
		    background-color: #5a5c69;
		    color: white;
		}
		.listArea{
			min-height: 300px;
			max-height: 300px;
			overflow: auto;
		}
		.listAreaMini{
			min-height: 120px;
			max-height: 120px;
			overflow: auto;
		}
  	</style>
  
</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
		<%@ include file="/WEB-INF/views/includes/AdminSideBar.jsp" %>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
				<%@ include file="/WEB-INF/views/includes/AdminTopBar.jsp" %>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">스케줄 등록 페이지 - AdminSchedules.jsp</h1>
                    </div>
					
					<!--  Content Row -->
					<!-- 영화, 극장, 상영관 선택 -->
					<div class="row text-gray-100" style="display:block;">
						<div class="card shadow mb-4">
                               <div class="card-header py-3 bg-gray-900">
                                   <h6 class="m-0 font-weight-bold text-white">영화</h6>
                               </div>
                               <div class="card-body listArea pl-1" id="mvList">
                                  	<div class="pl-1 text-md text-gray-800">
       	                            <c:forEach items="${mvList }" var="movie" >
	                               		<div class="btn font-weight-bold " id="${movie.mvcode }" onclick="mvSelect(this, '${movie.mvcode}')"
	                                  		style="text-align:left; display:block;">${movie.mvname }</div>
           	                        </c:forEach>
                                  	</div>
                               </div>
                           </div>
					</div>
					<!-- 날짜, 시간 선택 -->
					<div class="row text-gray-100" style="min-heigth:500px;">
						<div class="col-5 pr-0 pl-0">
							<div class="card shadow mb-4">
                                <div class="card-header py-3 bg-gray-900">
                                    <h6 class="m-0 font-weight-bold text-white">극장</h6>
                                </div>
                                <div class="card-body listArea pl-1" id="thList">
                                   	<!-- 극장목록 출력 -->
                                   	<div class="pl-1 text-md text-gray-800">
        	                            <c:forEach items="${thList }" var="theater" >
        	                            	<c:if test="${theater.thstate == 0 }">
		                               		<div class="btn font-weight-bold " id="${theater.thcode }" onclick="thSelect(this, '${theater.thcode}')"
		                                  		style="text-align:left; display:block;">${theater.thname }</div>
		                                  	</c:if>
            	                        </c:forEach>
                                   	</div>

                                </div>
                            </div>
						</div>
						<div class="col-3 pr-0 pl-0">
							<div class="card shadow mb-4">
                                <div class="card-header py-3 bg-gray-900">
                                    <h6 class="m-0 font-weight-bold text-white">상영관</h6>
                                </div>
                                <div class="card-body listArea pl-1" id="roomList">
                                   	<!-- 상영관 목록 출력 -->
                                   	<div class="pl-1 text-md text-gray-800">
	                               		<div class="btn font-weight-bold " id="" onclick="roomSelect(this)" style="text-align:left; display:block;">IMAX관</div>                                   		
	                               		<div class="btn font-weight-bold " id="" onclick="roomSelect(this)" style="text-align:left; display:block;">1관</div>                                   		
	                               		<div class="btn font-weight-bold " id="" onclick="roomSelect(this)" style="text-align:left; display:block;">2관</div>                                   		
	                               		<div class="btn font-weight-bold " id="" onclick="roomSelect(this)" style="text-align:left; display:block;">3관</div>                                   		
	                               		<div class="btn font-weight-bold " id="" onclick="roomSelect(this)" style="text-align:left; display:block;">4관</div>                                   		
	                               		<div class="btn font-weight-bold " id="" onclick="roomSelect(this)" style="text-align:left; display:block;">5관</div>                                   		
	                               		<div class="btn font-weight-bold " id="" onclick="roomSelect(this)" style="text-align:left; display:block;">6관</div>                                   		
	                               		<div class="btn font-weight-bold " id="" onclick="roomSelect(this)" style="text-align:left; display:block;">7관</div>                                   		
	                               		<div class="btn font-weight-bold " id="" onclick="roomSelect(this)" style="text-align:left; display:block;">8관</div>                                   		
                                   	</div>

                                </div>
                            </div>
						</div>
						<div class="col-4 pr-0 pl-0">
							<div class="card shadow mb-0">
                                <div class="card-header py-3 bg-gray-900">
                                    <h6 class="m-0 font-weight-bold text-white">상영일</h6>
                                </div>
                                <div class="card-body pl-1 listAreaMini" id="scdateList">
                                   	<div class="pl-1 text-md text-gray-800">
		                               	<div class="btn font-weight-bold " id="" 
		                               		style="text-align:left; display:block;">
		                               		<input type="date" name="scdate" onchange="scdaySelect(this)" id="dateInput">	
		                               	</div>
                                   	</div>
                                </div>
                            </div>
							<div class="card shadow mb-4">
                                <div class="card-header py-3 bg-gray-900">
                                    <h6 class="m-0 font-weight-bold text-white">상영시간</h6>
                                </div>
                                <div class="card-body pl-1 listAreaMini" id="sctimeList">
                                   	<div class="pl-1 text-md text-gray-800">
		                               	<div class="btn font-weight-bold " id="" 
		                               		style="text-align:left; display:block;">
		                               		<input type="time" name="sctime" onchange="sctimeSelect(this)">	
		                               	</div>
                                   	</div>
                                </div>
                            </div>
						</div>			
					</div>		
					<form action="adminSchedulesRegister" method="post" onsubmit="return scheduleConfirm()">
						<div class="pt-3 pb-3">
							<input class="btn btn-primary btn-user btn-block" type="submit" value="등록하기">
						</div>
							<input type="text" id="selMvCode" name="scmvcode" placeholder="영화코드">
							<input type="text" id="selThCode" name="scthcode" placeholder="극장코드">
							<input type="text" id="selScRoom" name="scroom" placeholder="상영관">
							<input type="text" id="selScDate" name="scdate" placeholder="상영일 및 시간" >
							<input type="text" id="confirmTime" name="confirmTime" placeholder="확인할 시간" >
					</form>
					
					<!--  Content Row -->

					<!--  Content Row -->

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; Your Website 2021</span>
                    </div>
                </div>
            </footer>
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

 
    <!-- Bootstrap core JavaScript-->
    <script src="${pageContext.request.contextPath }/resources/vendor/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath }/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="${pageContext.request.contextPath }/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="${pageContext.request.contextPath }/resources/js/sb-admin-2.min.js"></script>
    
    <script type="text/javascript">
    	var checkMsg = "${msg}"
    	console.log(checkMsg.length);
    	if(checkMsg.length > 0){
    		alert(checkMsg);
    	}
    </script>
    
    <script type="text/javascript">
    	$(document).ready(function(){
    		var today = new Date().toISOString().slice(0,10);
    		$("#dateInput").val(today).attr("min", today);
    	});
    </script>

    <script type="text/javascript">
    
    	var scday = "";
    	var sctime = "";
    	
    	var confirmScmvcode = false;
    	var confirmScthcode = false;
    	var confirmScroom = false;
    	var confirmScday = false;
    	var confirmSctime = false;

    	function mvSelect(selObj, scmvcode){
			// 선택 영화 CSS 변경
			$("#mvList div").css("background-color","").css("color","");
			$(selObj).css("background-color","#5a5c69").css("color","white");
			// 선택 영화코드 input 태그에 입력
			$("#selMvCode").val(scmvcode);
			// onsubmit Confirm			
			confirmScmvcode = true;
		}
		
		function thSelect(selObj, scthcode){
			// 선택 극장 CSS 변경
			$("#thList div").css("background-color","").css("color","");
			$(selObj).css("background-color","#5a5c69").css("color","white");
			// 선택 극장코드 input 태그에 입력
			$("#selThCode").val(scthcode);
			// onsubmit Confirm			
			confirmScthcode = true;
		}
		
		function roomSelect(selObj){
			// 선택 상영관 CSS 변경
			$("#roomList div").css("background-color","").css("color","");
			$(selObj).css("background-color","#5a5c69").css("color","white");
			// 선택 상영관 input 태그에 입력
			$("#selScRoom").val($(selObj).text());
			// onsubmit Confirm			
			confirmScroom = true;
		}
		
		function scdaySelect(selObj){
			// 선택 상영일 input 태그에 입력
			scday = $(selObj).val();
			if(confirmSctime){
				$("#selScDate").val( scday + " " + sctime);
			} else {
				$("#selScDate").val(scday);
			}
			// onsubmit Confirm			
			confirmScday = true;
		}
		
		function sctimeSelect(selObj){
			// 선택 상영일 input 태그에 입력
			sctime = $(selObj).val();
			if (confirmScday) {
				$("#selScDate").val( scday +" "+ sctime);
			}  else {
				$("#selScDate").val( sctime);
			}
			// onsubmit Confirm			
			confirmSctime = true;
		}
		
		function scheduleConfirm(){
		
			$("#confirmTime").val(getFullYmdStr());
			console.log(getFullYmdStr());
			
			if (confirmScmvcode && confirmScthcode && confirmScroom && confirmScday && confirmSctime){
				return true;
			} else {
				return false;
			}
		}
		
		function getFullYmdStr(){
			var scdate = $("#selScDate").val();
			var time1 = new Date(scdate);
			console.log("선택한 scdate : " + time1);
			time1.setHours(time1.getHours() - 3);
			console.log("확인할 confirmTime : " + time1);
			var year = time1.getFullYear();
			if (time1.getMonth()+1 < 10){
				var month = "0"+ (time1.getMonth()+1);
			} else {
				var month = time1.getMonth()+1;
			}
			if (time1.getDate() < 10){
				var day = "0"+ time1.getDate();
			} else {
				var day = time1.getDate();
			}
			if (time1.getHours() < 10){
				var hour = "0" + time1.getHours();
			} else {
				var hour = time1.getHours();
			}
			if (time1.getMinutes() < 10){
				var minutes = "0"+time1.getMinutes();
			} else {
				var minutes = time1.getMinutes();
			}
			
		    //년월일시분초 문자열 생성
		    return year + "/" + month + "/" + day + " " + hour + ":" + minutes ;
		}
    </script>

</body>

</html>