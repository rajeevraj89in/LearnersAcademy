<jsp:include page="/include/header.jsp"></jsp:include>
<%@ page import="com.learners.hibernate.entity.Subject"%>
<%@ page import="com.learners.hibernate.entity.Myclass"%>
<%@ page import="com.learners.hibernate.entity.Teacher"%>
<%@ page import="java.util.List"%>
<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">Class List</h1>
	<!-- <p class="mb-4">
		DataTables is a third party plugin that is used to generate the demo
		table below. For more information about DataTables, please visit the <a
			target="_blank" href="https://datatables.net">official DataTables
			documentation</a>.
	</p> -->

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<a class="btn btn-md btn-primary" href="">Add Class</a>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th class="text-center">Assign Teacher</th>
							<th class="text-center">Action</th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th class="text-center">Assign Teacher</th>
							<th class="text-center">Action</th>
						</tr>
					</tfoot>
					<tbody>
						<%
							List<Myclass> myclass = (List<Myclass>) request.getAttribute("listclass");
							for (Myclass mclass : myclass) {
								out.print("<tr><td>" + mclass.getId() + "</td><td>" + mclass.getName()
										+ "</td><td class=\"text-center\"><a class=\"btn btn-sm btn-primary assign\" data-name=\""
										+ mclass.getName() + "\" data-id=\"" + mclass.getId()
										+ "\"><i class=\"fas fa-plus fa-sm\"></i></a></td><td class=\"text-center\"><a class=\"btn btn-sm btn-warning\" href=\""
										+ request.getContextPath() + "/SubjectSurvlet?action=edit&id=" + mclass.getId()
										+ "\"><i class=\"fas fa-pencil-alt fa-sm\"></i>&nbsp;Edit</a>&nbsp;&nbsp;<a class=\"btn btn-sm btn-danger\" href=\""
										+ request.getContextPath() + "/SubjectSurvlet?action=delete&id=" + mclass.getId()
										+ "\"><i class=\"fas fa-trash fa-sm\"></i>&nbsp;Delete</a></td></tr>");
							}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
<!-- /.container-fluid -->
<div class="modal" tabindex="-1">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Assign Teacher to Class</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<form method="post"
				action="<%=request.getContextPath()%>/ClassServlet?action=assign_teacher">
				<input type="hidden" name="class">
				<div class="modal-body">
					<div class="row">
						<div class="form-group col-md-6">
							<label>Class</label> <input type="text" class="form-control"
								id="class_name" disabled="disabled">
						</div>
						<div class="form-group col-md-6">
							<label>Subject</label> <select class="form-control"
								name="subject" id="subject" required="required">
								<option value="">Select Subject</option>
									<%
										List<Subject> subject = (List<Subject>) request.getAttribute("listsubject");
										for (Subject sub : subject) {
											out.print("<option value=\"" + sub.getName() + "\">" + sub.getName() + "</option>");
										}
									%>
								
							</select>
						</div>
						<div class="form-group col-md-6">
							<label>Teacher</label> <select class="form-control"
								name="teacher" id="teacher" required="required">
								<option value="">Select Teacher</option>
								<%
										List<Teacher> teachers = (List<Teacher>) request.getAttribute("listteacher");
										for (Teacher tech : teachers) {
											out.print("<option value=\"" + tech.getName() + "\">" + tech.getName() + "</option>");
										}
									%>

							</select>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button type="submit" class="btn btn-primary">Assign</button>
				</div>
			</form>
		</div>
	</div>
</div>
<jsp:include page="/include/footer.jsp"></jsp:include>
<script>
	$(document).ready(function() {
		$(".assign").on('click', function() {
			var class_name = $(this).data("name");
			$('input').val(class_name);
			$(".modal").modal('show');
		});
	});
</script>
