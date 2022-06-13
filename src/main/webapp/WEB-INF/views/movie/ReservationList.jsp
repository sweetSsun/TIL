<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page import="java.util.Date" %>

<!DOCTYPE html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
	<script src="https://kit.fontawesome.com/9125416ae4.js" crossorigin="anonymous"></script>

    <title>예매내역</title>

  	<%@ include file="/WEB-INF/views/includes/commonCss.jsp" %>
  	
  	<!-- Custom styles for this page -->
    <link href="${pageContext.request.contextPath }/resources/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
    
    <style type="text/css">
	    .table td{
	   		vertical-align : middle;
	    }
  
    </style>
</head>

<script type="text/javascript">
	var loginCheck = "${sessionScope.loginId}";
	if(loginCheck.length == 0){
		alert("로그인 후 이용 가능합니다.");
		location.href="memberLoginForm";
	}
</script>

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
                        <h1 class="h3 mb-0 text-gray-800">예매내역확인 페이지 - ReservationList.jsp</h1>
                    </div>
					
					<!--  Content Row -->
					<div class="container-fluid">
                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3 bg-gray-900">
                            <h6 class="m-0 font-weight-bold text-white">예매내역</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr class="bg-gray-700 text-white">
                                            <th>제목</th>
                                            <th>극장</th>
                                            <th>상영관</th>
                                            <th>일시</th>
                                            <th>인원</th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	<c:forEach items="${reList }" var="re">
	                                        <tr>
	                                            <td><a href="reservationInfo?recode=${re.recode }" class="btn p-0 font-weight-bold">${re.mvname }</a></td>
	                                            <td class="font-weight-bold">${re.thname }</td>
	                                            <td class="font-weight-bold">${re.rescroom }</td>
	                                            <td class="font-weight-bold">${re.rescdate }</td>
	                                            <td class="font-weight-bold">${re.reamount } 명</td>
	                                            <th>
	                                            	<c:set var="today" value="<%=new Date() %>"></c:set>
 	                                            	<fmt:parseDate value="${re.rescdate }" var="scdate_fm" pattern="yyyy.MM.dd HH:mm"></fmt:parseDate>
	                                            	
	                                            	<c:choose>
		                                            	<c:when test="${scdate_fm > today }">
	                                            			<button class="btn btn-danger btn-icon-split px-1" onclick="cancleReservation('${re.recode}')">예매취소</button>
	                                            		</c:when>
	                                            		<c:otherwise>
	                                            			<c:choose>
	                                            				<c:when test="${re.rvrecode != null }">
			                                            			<button class="btn btn-secondary btn-icon-split px-1" onclick="showReview('${re }', '${re.rvrecode }')">관람평 확인</button>
	                                            				</c:when>
	                                            				<c:otherwise>
			                                            			<button class="btn btn-primary btn-icon-split px-1" onclick="reviewWriteForm('${re }')">관람평 작성</button>
			                                            		</c:otherwise>
			                                            	</c:choose>
	                                            		</c:otherwise>
	                                            	</c:choose>
	                                            </th>
	                                        </tr>
                                    	</c:forEach>
                                    </tbody>
                                </table>
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

    <!-- Page level plugins -->
    <script src="${pageContext.request.contextPath }/resources/vendor/datatables/jquery.dataTables.min.js"></script>
    <script src="${pageContext.request.contextPath }/resources/vendor/datatables/dataTables.bootstrap4.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="${pageContext.request.contextPath }/resources/js/demo/datatables-demo.js"></script>
    
    <script type="text/javascript">
    	var checkMsg = "${msg}"
    	console.log(checkMsg.length);
    	if(checkMsg.length > 0){
    		alert(checkMsg);
    	}
    </script>
	<script type="text/javascript">
		function cancleReservation(recode){
			console.log("예매취소 요청");
			location.href="cancleReservation?recode="+recode;
		}
		
		function reviewWriteForm(reInfo){
			console.log("관람평 작성페이지 이동 요청");
			console.log(reInfo);
			var row1 = reInfo.replaceAll(", ",",");
			console.log(row1);
			var row2 = reInfo.replaceAll(", ",",").split('(')[1].split(')')[0];
			console.log(row2);
			var row = reInfo.replaceAll(", ",",").split('(')[1].split(')')[0].split(',');
			console.log(row);

			var reserveData = {};
			for(var i = 0; i < row.length; i++){
				var key = row[i].split('=')[0];
				var val = row[i].split('=')[1];
				reserveData[key] = val;
			}
			
			$("#review_mvposter").attr("src", reserveData.mvposter);
			$("#review_mvname").text(reserveData.mvname);
			$("#review_thname_rescroom").text(reserveData.thname + " " + reserveData.rescroom);
			$("#review_rescdate").text(reserveData.rescdate);
			$("#review_reamount").text(reserveData.reamount + "명");
			
			$("#review_modalLabel").text("관람평 작성");
			$("#review_rvcomment").val("");
			$("#review_rvrecode").val(reserveData.recode);
			$("#review_rvmvcode").val(reserveData.mvcode);
			$("#reviewModal").modal('show');
			
		}
		
		function showReview(reInfo, rvrecode){
			console.log("작성된 관람평 확인 요청");
			var row = reInfo.replaceAll(", ",",").split('(')[1].split(')')[0].split(',');
			var reserveData = {};
			for(var i = 0; i < row.length; i++){
				var key = row[i].split('=')[0];
				var val = row[i].split('=')[1];
				reserveData[key] = val;
			}
			
			$.ajax({
				type: "post",
				url: "getReview",
				data: {"rvrecode":rvrecode},
				dataType: "json",
				success: function(result){
					console.log(result);

					$("#rvInfo_mvposter").attr("src", reserveData.mvposter);
					$("#rvInfo_mvname").text(reserveData.mvname);
					$("#rvInfo_thname_rescroom").text(reserveData.thname + " " + reserveData.rescroom);
					$("#rvInfo_rescdate").text(reserveData.rescdate);
					$("#rvInfo_reamount").text(reserveData.reamount + "명");
					$("#rvInfo_rvrecode").val(reserveData.rvrecode);
					$("#rvInfo_rvmvcode").val(reserveData.mvcode);
					
					$("#rvInfo_modalLabel").text(result.rvrecode + " 관람평");
					// 모달창 관람평 수정이 왜이러는걸까요
					$("#rvInfo_rvcomment").text("");
					$("#rvInfo_rvcomment").text(result.rvcomment);
					if (result.rvrecommend == 1){
						$("#rvInfo_rvrecommend").html("<i class='fa-regular fa-thumbs-up'></i>좋아요");
					} else {
						$("#rvInfo_rvrecommend").html("<i class='fa-regular fa-thumbs-down'></i>별로예요");
					}
					$("#rvInfoModal").modal('show');
				}
			});
		}
		
		function modifyReview(){
			var recommend = $("#rvInfo_rvrecommend").text();
			console.log("추천 : " + recommend);
			var output = "";
			if (recommend=="좋아요"){
				output += "<input type='radio' name='rvrecommend' id='recommend1' value='1' checked='checked'><label for='recommend1'><i class='fa-regular fa-thumbs-up'></i>좋아요&nbsp;</label><input type='radio' name='rvrecommend' id='recommend2' value='0'><label for='recommend2'><i class='fa-regular fa-thumbs-down'></i>별로예요</label>";
			} else {
				output += "<input type='radio' name='rvrecommend' id='recommend1' value='1'><label for='recommend1'><i class='fa-regular fa-thumbs-up'></i>좋아요&nbsp;</label><input type='radio' name='rvrecommend' id='recommend2' value='0' checked='checked'><label for='recommend2'><i class='fa-regular fa-thumbs-down'></i>별로예요</label>";
			}

			$("#rvInfo_rvcomment").removeAttr("readonly");
			$("#modiPageBtn").toggleClass("d-none");
			$("#modiBtn").toggleClass("d-none");
			$("#rvInfo_rvrecommend").text("");
			$("#rvInfo_rvrecommend").html(output);
		}
	</script>    
	
	 <div class="modal fade" id="reviewModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h6 class="modal-title font-weight-bold " id="review_modalLabel"></h6>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <form action="insertReview" method="post">
	                <div class="modal-body p-3">
	                	<div class="row">
                           	<div class="col-5">
                                <div class="row no-gutters align-items-center">
                                    <div class="h6 mb-1 font-weight-bold text-gray-800 mr-auto ml-auto" >
                                 		<img class="img-fluid" alt="영화포스터" style="max-height:300px;" id="review_mvposter" src="">
                                    </div>
                                </div>
                            </div>
                           	<div class="col-7">
                                <div class="no-gutters align-items-center">
                                    <div class="h6 font-weight-bold text-gray-800">
		                                  <div id="review_mvname"></div>
		                                  <br>
		                                  <div id="review_thname_rescroom"></div>
		                                  <br>
		                                  <div id="review_rescdate"></div>
		                                  <br>
		                                  <div id="review_reamount"></div>
		                                  <br>
		                                  <input type="radio" name="rvrecommend" id="recommend1" value="1" checked="checked"><label for="recommend1">
		                                 	<i class="fa-regular fa-thumbs-up"></i>좋아요&nbsp;</label>
	                        			  <input type="radio" name="rvrecommend" id="recommend2" value="0"><label for="recommend2">
	                        			  	<i class="fa-regular fa-thumbs-down"></i>별로예요</label>
		                                  <textarea rows="3" name="rvcomment" id="review_rvcomment" class="form-control"></textarea>
                                    </div>
                                </div>
                            </div>
                        </div>
	                </div>
	                <input type="hidden" name="rvrecode" id="review_rvrecode">
	                <input type="hidden" name="rvmid" id="review_rvmid" value="${sessionScope.loginId }">
	                <input type="hidden" name="rvmvcode" id="review_rvmvcode">
	                <div class="modal-footer">
	                	<input type="submit" class="btn btn-primary" value="작성완료">
	                </div>
                </form>
            </div>
        </div>
    </div>
    
    <div class="modal fade" id="rvInfoModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h6 class="modal-title font-weight-bold " id="rvInfo_modalLabel"></h6>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <form action="modifyReview" method="post">
	                <div class="modal-body ">
	                	<div class="row">
	                		<div class="col-5">
                                <div class="no-gutters align-items-center">
                                    <div class="h6 mb-1 font-weight-bold text-gray-800" >
                                 		<img class="img-fluid" alt="영화포스터" style="max-height:300px;" id="rvInfo_mvposter" src="">
                                    </div>
                                </div>
                            </div>
                           	<div class="col-7">
                                <div class="no-gutters align-items-center">
                                    <div class="h6 font-weight-bold text-gray-800">
	                                  <div id="rvInfo_mvname"></div>
	                                  <br>
	                                  <div id="rvInfo_thname_rescroom"></div>
	                                  <br>
	                                  <div id="rvInfo_rescdate"></div>
	                                  <br>
	                                  <div id="rvInfo_reamount"></div>
	                                  <br>
	                                  <div id="rvInfo_rvrecommend" style="font-weight:normal; font-size:medium;"></div>
	                                  <!-- 관람평 수정 시에 추천/비추천도 다시 선택할 수 있도록 만들어보기 -->
	                                  <textarea rows="3" readonly name="rvcomment" id="rvInfo_rvcomment" class="form-control"></textarea>
                                    </div>
                                </div>
                            </div>
                        </div>
	                </div>
	                <input type="hidden" name="rvrecode" id="rvInfo_rvrecode">
	                <input type="hidden" name="rvmid" id="rvInfo_rvmid" value="${sessionScope.loginId }">
	                <input type="hidden" name="rvmvcode" id="rvInfo_rvmvcode">
	                <div class="modal-footer">
	                	<input type="button" class="btn btn-primary" id="modiPageBtn" value="관람평 수정" onclick="modifyReview()">
	                	<input type="submit" class="btn btn-primary d-none"  id="modiBtn" value="수정완료">
	                </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>