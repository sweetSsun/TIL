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

    <title>관리자 - 스케줄 등록_Array</title>

  	<%@ include file="/WEB-INF/views/includes/commonCss.jsp" %>
  	
  	<style type="text/css">
  	
	  	input[type=checkbox]{
	  	 	 display: none;
	  	 	 top: 1.5px;
 		    overflow: visible;
		}
  		input[type=checkbox]+label{
    		background-color: #fff;
    		color: #333;
    		cursor: pointer;
 			height: 28px;
 		    width: 55px;
 		    border: 1px solid #8c8c8d;
 		    text-align: center;
 		    border-radius: 5px;
		}
		input[type=checkbox]:checked+label{
		    background-color: #5a5c69;
		    color: white;
		}
		.listArea{
			min-height: 300px;
			max-height: 300px;
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
                        <h1 class="h3 mb-0 text-gray-800">스케줄 등록_Array 페이지 - AdminSchedules_Array.jsp</h1>
                    </div>
					
					<!--  Content Row -->
					<!-- 영화, 극장, 상영관 선택 -->
																	<form action="adminSchedulesRegister_Array" method="post" onsubmit="return scheduleConfirm()">
					
					<div class="row text-gray-100">
						<div class="col-5 pr-0 pl-0">
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
                         <div class="col-3 pr-0 pl-0">
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
						<div class="col-4 pr-0 pl-0">
							<div class="card shadow mb-0">
                                <div class="card-header py-3 bg-gray-900">
                                    <h6 class="m-0 font-weight-bold text-white">상영일</h6>
                                </div>
                                <div class="card-body pl-1 listAreaMini" id="scdateList">
                                   	<div class="pl-1 text-md text-gray-800">
		                               	<div class="btn font-weight-bold " id="" 
		                               		style="text-align:left; display:block;">
		                               		<input type="date" onchange="scdaySelect(this)">	
		                               	</div>
                                   	</div>
                                </div>
                            </div>
						</div>
					</div>
					
					<!-- 날짜, 시간 선택 -->
					<div class="row text-gray-100">
						<div class="col-6 pr-0 pl-0">
							<div class="card shadow mb-4">
                                <div class="card-header py-3 bg-gray-900">
                                    <h6 class="m-0 font-weight-bold text-white">상영관 및 시간</h6>
                                </div>
                                <div class="card-body listArea pl-1">
                               		<!-- 상영관 및 시간 목록 출력 -->
                                   	<div class="pl-1 text-md text-gray-800 labelBtn" id="scroomTimeList">
                                   		
                                   	</div>
                                </div>
                            </div>
						</div>

                        <div class="col-6 pr-0 pl-0">
							<div class="card shadow mb-4">
                                <div class="card-header py-3 bg-gray-900">
                                    <h6 class="m-0 font-weight-bold text-white">선택 확인</h6>
                                </div>
                                <div class="card-body pl-1 listArea" id="sctimeList">
                                   	<div class="pl-1 text-md text-gray-800">
		                                <input type="text" id="selMvCode" name="scmvcode" placeholder="영화코드">
										<input type="text" id="selThCode" name="scthcode" placeholder="극장코드">
										<input type="text" id="selScDate" name="scdate" placeholder="상영일">
                                   	</div>
									<div class="pt-3 pb-3" style="text-align:right;">
										<input class="btn btn-primary btn-user" type="submit" value="등록하기" style="background-color:#4e2d44; border-color:#4e2d44;">
									</div>
                                </div>
                            </div>
						</div>			
					</div>		
					
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
    
    	var scmvcode = "";
    	var scthcode = "";
    	var scday = "";
    	
    	var confirmScmvcode = false;
    	var confirmScthcode = false;
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
			scmvcode = scmvcode;
			
			getScroomTime();
		}
		
		function thSelect(selObj, scthcode){
			// 선택 극장 CSS 변경
			$("#thList div").css("background-color","").css("color","");
			$(selObj).css("background-color","#5a5c69").css("color","white");
			// 선택 극장코드 input 태그에 입력
			$("#selThCode").val(scthcode);
			// onsubmit Confirm			
			confirmScthcode = true;
			scthcode = scthcode;
			
			getScroomTime();
		}
		
		function scdaySelect(selObj){
			// 선택 상영일 input 태그에 입력
			scday = $(selObj).val();
			$("#selScDate").val(scday);
			// onsubmit Confirm			
			confirmScday = true;
			
			getScroomTime();
		}

		function getScroomTime(){
			// ajax 추가해서 데이터값 받아오기~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			var scroomList = ['1관', '2관', '3관', '4관', '5관', '6관', '7관'];
			var sctimeList = ['09:00', '11:30', '14:00', '16:30', '19:00', '21:30'];
			
			var output = "";
			var scroom = "";
			
			if(confirmScmvcode && confirmScthcode && confirmScday){
				
				for(var i = 0; i < scroomList.length; i++){
					if(i != 0) {
	   					output += "<hr class='my-1'>";
	   				}
					output += "<div class='font-weight-bold text-gray-800 ml-2 my-1'>" + scroomList[i] + "</div>"
					for(var j = 0; j < sctimeList.length; j++){
						var scroomTime = scroomList[i] + " " + sctimeList[j];
						output += "<input type='checkbox' id='"+scroomTime+"' name='scroomTime' value='"+scroomTime+"'><label for='"+scroomTime+"' class='btn btn-sm font-weight-bold my-1 mx-1'>"+sctimeList[j]+"</label>";
					}
				}
			}
			$("#scroomTimeList").text("");
			$("#scroomTimeList").html(output);
			
		}
		
		
		function scheduleConfirm(){
			if (!confirmScmvcode){
				alert("영화를 선택해주세요.");
				return false;
			}
			if (!confirmScthcode){
				alert("극장을 선택해주세요.");
				return false;
			}
			if (!confirmScday){
				alert("날짜를 선택해주세요.");
				return false;
			}
			if (!$("input[name='scroomTime']").is(":checked")){
				alert("상영관 및 시간을 선택해주세요.");
				return false;
			}
		}
		
		
    </script>

</body>

</html>