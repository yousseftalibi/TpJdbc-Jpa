package isep.mywebapp.Models;
import java.util.Date;
public class EmpOld {
    public Long getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Long empNo) {
        this.empNo = empNo;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEfirst() {
        return efirst;
    }

    public void setEfirst(String efirst) {
        this.efirst = efirst;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public EmpOld getMgr() {
        return mgr;
    }

    public void setMgr(EmpOld mgr) {
        this.mgr = mgr;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public int getComm() {
        return comm;
    }

    public void setComm(int comm) {
        this.comm = comm;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public Dept getDepartment() {
        return department;
    }

    public void setDepartment(Dept department) {
        this.department = department;
    }
    private Long empNo;
    private String ename;
    private String efirst;
    private String job;
    private EmpOld mgr;
    private Date hireDate;
    private int sal;
    private int comm;
    private int tel;
    private Dept department;

}