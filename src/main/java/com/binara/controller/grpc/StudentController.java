package com.binara.controller.grpc;

import com.binara.model.Student;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;

/**
 * Created by binara on 7/8/17.
 */

public class StudentController extends StudentGrpc.StudentImplBase {

    private final ArrayList<Student> students = new ArrayList<Student>(){
        {
            add(new Student(1, "Vindana", 36));
            add(new Student(2, "Sithum", 33));
            add(new Student(3, "Binara", 27));
        }
    };

    @Override
    public void getStudent(StudentRequest request, StreamObserver<StudentResponse> responseObserver) {
        Student student = students.get(request.getId());
        StudentResponse response = StudentResponse.newBuilder()
                .setId(student.getId())
                .setName(student.getName())
                .setAge(student.getAge())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();

    }

}
