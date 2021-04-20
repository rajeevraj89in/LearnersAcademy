<jsp:include page="/include/header.jsp"></jsp:include>
<%@ page import="com.learners.hibernate.entity.Subject"%>
<%@ page import="com.learners.hibernate.entity.Myclass"%>
<%@ page import="java.util.List"%>
<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">Subject List</h1>
	<!-- <p class="mb-4">
		DataTables is a third party plugin that is used to generate the demo
		table below. For more information about DataTables, please visit the <a
			target="_blank" href="https://datatables.net">official DataTables
			documentation</a>.
	</p> -->

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<a class="btn btn-md btn-primary" href="">Add Subject</a>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th class="text-center">Assign Class</th>
							<th class="text-center">Action</th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th class="text-center">Assign Class</th>
							<th class="text-center">Action</th>
						</tr>
					</tfoot>
					<tbody>
						<%
							List<Subject> subject = (List<Subject>) request.getAttribute("listsubject");
							for (Subject sub : subject) {
								out.print("<tr><td>" + sub.getId() + "</td><td>" + sub.getName()
										+ "</td><td class=\"text-center\"><a class=\"btn btn-sm btn-primary assign\" data-name=\""
										+ sub.getName() + "\" data-id=\"" + sub.getId()
										+ "\"><i class=\"fas fa-plus fa-sm\"></i></a></td><td class=\"text-center\"><a class=\"btn btn-sm btn-warning\" href=\""
										+ request.getContextPath() + "/SubjectSurvlet?action=edit&id=" + sub.getId()
										+ "\"><i class=\"fas fa-pencil-alt fa-sm\"></i>&nbsp;Edit</a>&nbsp;&nbsp;<a class=\"btn btn-sm btn-danger\" href=\""
										+ request.getContextPath() + "/SubjectSurvlet?action=delete&id=" + sub.getId()
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
				<h5 class="modal-title">Assign Class to Subject</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<form method = "post" action="<%= request.getContextPath()%>/SubjectServlet?action=assign_class">
			<input type="hidden" name="subject">
				<div class="modal-body">
					<div class="row">
						<div class="form-group col-md-6">
							<label>Subject</label> <input type="text" class="form-control" id="sub_name" disabled="disabled">
						</div>
						<div class="form-group col-md-6">
							<label>Class</label>
							 <select class="form-control" name="class" id="class">
								<option value="">Select Class<option>
								<%
									String options = "";
									List<Myclass> myclass = (List<Myclass>) request.getAttribute("listclass");
									for (Myclass mclass : myclass) {
										//options += "";
										out.print("<option value=\"" + mclass.getName() + "\">" + mclass.getName() + "</option>");
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
			var sub_name = $(this).data("name");
			$('input').val(sub_name);
			$(".modal").modal('show');
		});
	});
</script>
