<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>영화예매</title>

  	<%@ include file="/WEB-INF/views/includes/commonCss.jsp" %>
  
</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
		<%@ include file="/WEB-INF/views/includes/SideBar.jsp" %>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
				<%@ include file="/WEB-INF/views/includes/TopBar.jsp" %>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">영화예매 페이지 - MovieReservationpage.jsp</h1>
                    </div>
					<!--  Content Row -->
					<!-- 영화, 극장, 날짜및시간, 상영관 선택 -->
					<div class="row text-gray-100" style="min-heigth:500px;">
						<div class="col-4 pr-0">
							<div class="card shadow mb-4">
                                <div class="card-header py-3 bg-gray-900">
                                    <h6 class="m-0 font-weight-bold text-white">영화</h6>
                                </div>
                                <div class="card-body listArea pl-1 " id="mvList">
                                   	<div class="pl-1 text-md text-gray-800">
        	                            <c:forEach items="${reMvList }" var="reMv">
                                    		<div class="btn font-weight-bold " onclick="mvSelect(this, '${reMv.mvcode}', '${reMv.mvposter }')"
                                    		style="text-align:left; display:block;">${reMv.mvname }</div>
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
                                </div>
                            </div>
						</div>
						<div class="col-2 pr-0 pl-0">
							<div class="card shadow mb-4">
                                <div class="card-header py-3 bg-gray-900">
                                    <h6 class="m-0 font-weight-bold text-white">날짜</h6>
                                </div>
                                <div class="card-body listArea pl-1" id="dayList">
                                    <!-- 날짜목록 출력 -->
                                </div>
                            </div>
						</div>						
						<div class="col-3 pl-0">
							<div class="card shadow mb-4">
                                <div class="card-header py-3 bg-gray-900">
                                    <h6 class="m-0 font-weight-bold text-white">시간 및 상영관</h6>
                                </div>
                                <div class="card-body listArea pl-1" id="timeList">
                                   	<!-- 시간 및 상영관 출력 -->
                                </div>
                            </div>
						</div>
					 
					</div>
					
					<!--  Content Row -->
					<!-- 선택 항목 확인 -->
					<!-- 여기~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ input 전부다 입력됐는지 확인하고 넘기기 -->
					<form action="movieReservation" method="post" onsubmit="return selectCheck()">
					<div class="row mt-5 text-gray-100 bg-gray-900">
						<div class="col-3">
							<input type="hidden" name="remid" value="${sessionScope.loginId }">
							<div class="pt-3 pb-3">
								<!-- 선택 영화 정보 -->
								<img class="img-fluid" alt="" src="" id="viewSelMvPoster" style="max-height:200px;">
								<div class="tx-sm" id="viewSelMvName"></div>
								<!-- <input type="text" id="selMvCode" name="mvcode"> -->
							</div>
						</div>  
						<div class="col-3">
							<div class="pt-3 pb-3">
								<!-- 선택 극장 및 상영관 정보 -->
								<div calss="tx-sm">극장 : <span id="viewSelMvTheater"></span></div>
								<input type="hidden" id="selThCode" name="rescthcode">
								<div calss="tx-sm">날짜 : <span id="viewSelMvDate"></span></div>
								<input type="hidden" id="selScDay" name="rescday" >
								<div calss="tx-sm">시간 : <span id="viewSelMvTime"></span></div>
								<input type="hidden" id="selScTime" name="resctime">
								<div calss="tx-sm">상영관 : <span id="viewSelScroom"></span></div>
								<input type="hidden" id="selScRoom" name="rescroom">
							</div>
						</div>  
						<div class="col-3">
							<div class="pt-3 pb-3">
								<div calss="tx-sm">
									관람인원
								</div>
								<div class="pt-1">
									<select name="reamount" id="selReamount">
										<option value="">인원선택</option>
										<option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
										<option value="5">5</option>
										<option value="6">6</option>
									</select>
								</div>
							</div>
						</div>  
						<div class="col-3">
							<div class="pt-3 pb-3">
								<input class="btn btn-danger btn-user btn-block" type="submit" 
								value="예매하기">
							</div>
						</div>  
					</div>
					</form>
					  

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
    	
    	// 선택값 저장할 전역변수
    	var mvcode = "";
    	var thcode = "";
    	var scday = "";
    	var sctime = "";
    	
    	// 영화 선택 후 극장 조회
    	function mvSelect(selObj, selMvcode, selMvposter){
    		// 선택 영화 CSS 변경
    		$("#mvList div").css("background-color","").css("color","");
    		$(selObj).css("background-color","#5a5c69").css("color","white");
    		
    		console.log("선택 영화 코드 : " + selMvcode);
    		console.log("선택 영화 제목 : " + $(selObj).text());
    		console.log("선택 영화 포스터 : " + selMvposter);
    		// 선택 영화 출력
    		$("#viewSelMvPoster").attr("src",selMvposter);
    		$("#viewSelMvName").text($(selObj).text());
    		$("#selMvCode").attr("value",selMvcode);
    		mvcode = selMvcode;
    		// 선택했던 극장/날짜/시간 삭제
    		$("#viewSelMvTheater").text("");
    		$("#selThCode").removeAttr("value");
    		$("#viewSelMvDate").text("");
    		$("#selScDay").removeAttr("value");
    		$("#viewSelMvTime").text("");
    		$("#selScTime").removeAttr("value");
    		$("#viewSelScroom").text("");
    		$("#selScRoom").removeAttr("value");
    		
    		
    		// 극장 조회
    		$.ajax({
    			type : "get",
    			url : "getThList",
    			data : {"mvcode" : selMvcode},
    			dataType : "json",
				async : false,
    			success: function(result){
					console.log(result);
					thOutput(result);   				
    			}	
    		});
    	}
    	
    	// 극장 출력문
    	function thOutput(result){
    		$("#thList").html("");
    		$("#dayList").html("");
    		$("#timeList").html("");
    		
    		var output = "<div class='pl-1 text-gray-900 text-md'>";
    		for (var i = 0; i < result.length; i++){
	    		output += "<div class='btn font-weight-bold' onclick='thSelect(this, \""+result[i].thcode+"\")' style='text-align:left; display:block;'>";
	    		output += result[i].thname;
	    		output += "</div>";
    		}
    		output += "</div>";
    		$("#thList").html(output);
    	}
    	
    	// 극장 선택 후 날짜 조회
    	function thSelect(selObj, selThcode){
    		// 선택 극장 CSS 변경
    		$("#thList div").css("background-color","").css("color","");
    		$(selObj).css("background-color","#5a5c69").css("color","white");
    		
    		console.log("선택 극장 이름 : " + $(selObj).text());
    		console.log("선택 극장 코드 : " + selThcode);
    		console.log("선택영화코드 : " + mvcode);
    		// 선택 극장 출력
    		$("#viewSelMvTheater").text($(selObj).text());
    		$("#selThCode").attr("value",selThcode);
    		thcode = selThcode;
    		// 선택했던 날짜/시간 삭제
    		$("#viewSelMvDate").text("");
    		$("#selScDay").removeAttr("value");
    		$("#viewSelMvTime").text("");
    		$("#selScTime").removeAttr("value");
    		$("#viewSelScroom").text("");
    		$("#selScRoom").removeAttr("value");

    		// 날짜 조회
    		$.ajax({
    			type : "get",
    			url : "getScDay",
    			data : {"mvcode":mvcode, "thcode":selThcode},
    			dataType : "json",
    			success: function(result){
    				console.log(result);
    				dayOutput(result);
    			}
    		});
    	}
    	
    	// 날짜 출력문
    	function dayOutput(result){
    		$("#dayList").html("");
    		$("#timeList").html("");
    		var output = "<div class='pl-1 text-gray-900 text-md'>";
    		for (var i = 0; i < result.length; i++){
	    		output += "<div class='btn font-weight-bold' onclick='daySelect(this, \""+result[i].scday+"\")' style='text-align:left; display:block;'>";
	    		output += result[i].scday;
	    		output += "</div>";
    		}
    		output += "</div>";
    		$("#dayList").html(output);
    	}
    	
    	// 날짜 선택 후 시간 및 상영관 조회
    	function daySelect(selObj, selScDay){
    		// 선택 날짜 CSS 변경
    		$("#dayList div").css("background-color","").css("color","");
    		$(selObj).css("background-color","#5a5c69").css("color","white");
    		
    		// 선택 날짜 출력
    		$("#viewSelMvDate").text($(selObj).text());
    		$("#selScDay").attr("value",selScDay);
    		scday = selScDay;
    		// 선택했던 시간 삭제
    		$("#viewSelMvTime").text("");
    		$("#selScTime").removeAttr("value");
    		$("#viewSelScroom").text("");
    		$("#selScRoom").removeAttr("value");
    		console.log("선택 영화 코드 : " + mvcode);
    		console.log("선택 극장 코드 : " + thcode);
    		console.log("선택 날짜 : " + scday);
    		
    		// 시간 및 상영관 조회
     		$.ajax({
    			type : "get",
    			url : "getScTime",
    			data : {"mvcode":mvcode, "thcode":thcode, "scday":selScDay},
    			dataType : "json",
    			success: function(result){
    				console.log(result);
    				timeOutput(result);
    			}
    		});
    	}
    	
    	// 시간 출력문
    	function timeOutput(result){
    		$("#timeList").html("");
    		var output = "<div class='pl-1 text-gray-900 text-md'>";
			/* 상영관 따라서 시간 몰아주고 싶은데 어떻게 하면 좋을까.... */
    		for (var i = 0; i < result.length; i++){
    			output += "<div class='btn font-weight-bold' onclick='timeSelect(this, \""+result[i].sctime+"\", \""+result[i].scroom+"\")'>";
	    		output += result[i].sctime + "&nbsp;&nbsp;";
	    		output += result[i].scroom;
	    		output += "</div>";
	    		
    		}
    		output += "</div>";
    		$("#timeList").html(output);
    	}
    	
    	// 시간 선택
    	function timeSelect(selObj, sctime, scroom){
    		// 선택 시간 CSS 변경
    		$("#timeList div").css("background-color","").css("color","");
    		$(selObj).css("background-color","#5a5c69").css("color","white");
    		
    		// 선택 시간 출력
    		$("#viewSelMvTime").text(sctime);
    		$("#selScTime").attr("value",sctime);
    		$("#viewSelScroom").text(scroom);
    		$("#selScRoom").attr("value",scroom);
    	}
    	
    	// onsubmit (전부 선택했는지 확인)
    	function selectCheck(){
    		console.log("selectCheck() 호출");
    		if ($("#selThCode").val().length == 0){
    			alert("영화를 선택해주세요.");
    			return false;
    		}
    		if ($("#selScDay").val().length == 0){
    			alert("상영날짜를 선택해주세요.");
    			return false;
    		}
    		if ($("#selScTime").val().length == 0){
    			alert("상영시간을 선택해주세요.");
    			return false;
    		}
    		if ($("#selReamount").val().length == 0){
    			alert("인원을 선택해주세요.");
    			return false;
    		}
    	}
    	
    </script>

</body>

</html>