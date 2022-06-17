<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>채팅</title>

  	<%@ include file="/WEB-INF/views/includes/commonCss.jsp" %>
  
</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
		<%@ include file="includes/SideBar.jsp" %>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
				<%@ include file="includes/TopBar.jsp" %>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">채팅 - ChatPage.jsp</h1>
                    </div>
                    
                    <div class="row">
						<div class="col-8 card px-0">
                            <div class="card-header py-3 bg-gray-900">
                                <h6 class="m-0 font-weight-bold text-white text-center" >채팅메시지</h6>
                            </div>
                            <div class="card-body listArea" style="height:100px; overflow:auto;">
                              	<div class="text-md text-gray-800" id="receiveMsg">
                              	
                                </div>
                            </div>
                        </div>
						<div class="col-4 card px-0">
                            <div class="card-header py-3 bg-gray-900">
                                <h6 class="m-0 font-weight-bold text-white text-center">메시지 입력</h6>
                            </div>
                            <div class="card-body listArea" id="mvList">
                              	<div class="text-md text-gray-800">
									<input type="text" id="comment" placeholder="메시지 입력" style="width:100%">
									<br>
									<button class="btn btn-facebook btn-block" onclick="msgSendTest()"> 전송 </button>
                                </div>
                            </div>
                        </div>
					</div>
					
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
    
    <!-- sockJs -->
    <script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
    
    <script type="text/javascript">
    	var testUrl = "${pageContext.request.contextPath }/chatWskMessage";
	    var sock = new SockJS(testUrl);
	    sock.onopen = function() {
	        console.log('open');
	    };
	
	    sock.onmessage = function(e) {
	        var receiveData = JSON.parse(e.data);
	        console.log(receiveData);
	        var output = "<div class='my-2 text-left'><div><span class='small text-gray-700'>"+receiveData.msgUserId+"</span></div>";
	        output += "<span class='font-weight-bold bg-info text-white p-1' style='border-radius:0.35rem'>"+receiveData.msgComment+"</span></div>";
	        
	        $("#receiveMsg").append(output);
 	        $("#receiveMsg").scrollTop($("#receiveMsg")[0].scrollHeight);
	    };
	
	    sock.onclose = function() {
	        console.log('close');
	    };
    </script>
    
    <script type="text/javascript">
    	function msgSendTest(){
    		var username = '${sessionScope.loginId }';
    		var comment = $("#comment").val();
    		
    		if(comment.trim().length > 0){
    			// trim() : 공백을 제거
    		
	    		$("#comment").val("");
	    		var msgData = {
	    			msgUserId : username,
	    			msgComment : comment
	    		};
				console.log(JSON.stringify(msgData));
	    		sock.send(JSON.stringify(msgData));
	    		
	    		var output = "<div class='my-2 text-right'><span class='font-weight-bold bg-light text-black p-1' style='border-radius:0.35rem'>"+comment+"</span></div>";
	 	        
	 	        $("#receiveMsg").append(output);
	 	        $("#receiveMsg").scrollTop($("#receiveMsg")[0].scrollHeight);
	 	        // overflow : scroll의 값을 최대값으로 바꾼다(스크롤바 하단으로 이동)
    		}
 	       
    	}
    </script>
    
    <script type="text/javascript">
    	var checkMsg = "${msg}"
    	console.log(checkMsg.length);
    	if(checkMsg.length > 0){
    		alert(checkMsg);
    	}

    </script>
    
    

</body>

</html>