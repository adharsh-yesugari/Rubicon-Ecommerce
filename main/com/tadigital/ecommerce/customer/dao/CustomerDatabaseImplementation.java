package main.com.tadigital.ecommerce.customer.dao;

import main.com.tadigital.ecommerce.customer.entity.AddressDetails;
import main.com.tadigital.ecommerce.customer.entity.ContactDetailsUpdate;
import main.com.tadigital.ecommerce.customer.entity.Customer;
import main.com.tadigital.ecommerce.customer.entity.PersonalDetails;
import main.com.tadigital.ecommerce.dao.Dao;

import java.sql.*;
public class CustomerDatabaseImplementation extends Dao implements CustomerDatabase {
    @Override
    public boolean insertCustomer(Customer customer) {
        boolean status = false;
        Connection con = null;
        PreparedStatement pStmt = null;

        try {
            con = getConnection();
            pStmt = getPreparedStatement(con, CustomerSQL.INSERT_CUSTOMER_INFO);
            pStmt.setString(1, customer.getFirstName());
            pStmt.setString(2, customer.getLastName());
            pStmt.setString(3, customer.getEmail());
            pStmt.setString(4, customer.getPassword());
            int row = pStmt.executeUpdate();
            if (row != 0) {
                status = true;
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {

            closePreparedStatement(pStmt);
            closeConnection(con);
        }
        return status;
    }

    @Override
    public Customer searchCustomerByEmailAndPassword(Customer customer) {
        Customer status = null;
        Connection con = null;
        PreparedStatement pStmt = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            pStmt = getPreparedStatement(con, CustomerSQL.SEARCH_CUSTOMER_BY_EMAIL_AND_PASSWORD);
            pStmt.setString(1, customer.getEmail());
            pStmt.setString(2, customer.getPassword());
            rs = getResultSet(pStmt);
            if (rs.next()) {
                customer.setId(rs.getInt("customer_ID"));
                customer.setFirstName(rs.getString("customer_firstName"));
                customer.setLastName(rs.getString("customer_lastName"));
                customer.setEmail(rs.getString("customer_emailID"));
                customer.setPassword(rs.getString("customer_password"));
                customer.setProfilePicture(rs.getString("customer_profilePicture"));
                status = new Customer(customer.getId(), customer.getFirstName(), customer.getLastName(),
                        customer.getEmail(), customer.getPassword(), customer.getProfilePicture());

            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            closeResultSet(rs);
            closePreparedStatement(pStmt);
            closeConnection(con);
        }
        return status;
    }

    @Override
    public Customer findCustomerByEmailId(Customer customer) {
        Customer status = null;
        Connection con = null;

        PreparedStatement pStmt = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            pStmt = getPreparedStatement(con, CustomerSQL.SEARCH_CUSTOMER_BY_EMAIL);

            pStmt.setString(1, customer.getEmail());
            rs = getResultSet(pStmt);

            if (rs.next()) {
                customer.setId(rs.getInt("customer_id"));
                customer.setFirstName(rs.getString("customer_firstName"));
                customer.setLastName(rs.getString("customer_lastName"));
                customer.setEmail(rs.getString("customer_emailID"));
                customer.setPassword(rs.getString("customer_password"));
                customer.setProfilePicture(rs.getString("customer_profilePicture"));
                status = new Customer(customer.getId(), customer.getFirstName(), customer.getLastName(),
                        customer.getEmail(), customer.getPassword(), customer.getProfilePicture());

            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            closeResultSet(rs);
            closePreparedStatement(pStmt);
            closeConnection(con);
        }
        return status;
    }

    @Override
    public boolean updatePassword(Customer customer) {
        boolean status = false;
        Connection con = null;
        Statement stmt = null;

        try {
            String updateSql = "UPDATE customer_details SET customer_password= '"
                    + customer.getNewPassword() + "' WHERE  customer_ID = " + customer.getId() + "";

            con = getConnection();
            stmt = getStatement(con);
            int row = stmt.executeUpdate(updateSql);
            System.out.println(row);
            if (row == 1) {
                status = true;
                System.out.println(status);
                return status;
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            closeStatement(stmt);
            closeConnection(con);
        }
        return status;
    }

    @Override
    public boolean customerPersonalUpdate(PersonalDetails personalDetails) {
        boolean status = false;
        Connection con = null;
        Statement stmt = null;
        try {
            String updateSql = "UPDATE customer_details SET customer_profilePicture ='"   +personalDetails.getProfilePicture()+
                    "',customer_firstName='"   +personalDetails.getFirstName()+
                    "', customer_lastName='"   +personalDetails.getLastName()+
                    "', customer_gender ='"     +personalDetails.getGender() +
                    "',  customer_dob = '"     +personalDetails.getDateOfBirth()+
                    "' WHERE customer_ID ='"       +personalDetails.getCustomerID()+
                    "'";


            con  =  getConnection();
            stmt =  getStatement( con );
            int row = stmt.executeUpdate(updateSql);
            if( row != 0 ) {
                status = true;
            }
        } catch( SQLException sqlEx ) {
            sqlEx.printStackTrace();
        } finally {
            closeStatement(stmt);
            closeConnection(con);
        }
        return status;
    }

    @Override
    public boolean contactDetailsUpdate(ContactDetailsUpdate contactDetailsUpdate) {
        boolean status = false;
        Connection con = null;
        Statement stmt = null;

        try {
            String updateSql = "UPDATE customer_details SET customer_emailID ='"     + contactDetailsUpdate.getEmail() +
                    "',  customer_phone = '"   +contactDetailsUpdate.getMobileNumber()+
                    "' WHERE customer_ID ='"  +contactDetailsUpdate.getID()+"'";

            con  =  getConnection();
            stmt =  getStatement( con );
            int row = stmt.executeUpdate(updateSql);
            if( row != 0 ) {
                status =true;
            }
        } catch( SQLException sqlEx ) {
            sqlEx.printStackTrace();
        } finally {
            closeStatement(stmt);
            closeConnection(con);
        }
        return status;
    }

    @Override
    public boolean addressDetailsInsert(AddressDetails addressDetails) {
        boolean status = false;
        Connection con = null;
        PreparedStatement pStmt = null;

        try {
            con  =  getConnection();
            pStmt = getPreparedStatement(con, CustomerSQL.INSERT_CUSTOMER_ADDRESS_INFO);

            pStmt.setString(1, addressDetails.getAddressLine1() );
            pStmt.setString(2, addressDetails.getAddressLine2());
            pStmt.setString(3, addressDetails.getAddressLine3());
            pStmt.setString(4, addressDetails.getPostalCode());
            pStmt.setString(5, addressDetails.getCity());
            pStmt.setString(6, addressDetails.getState());
            pStmt.setInt(7, addressDetails.getCustomerID());

            int row = pStmt.executeUpdate();
            if( row != 0 ) {
                status = true;
            }
        } catch( SQLException sqlEx ) {
            sqlEx.printStackTrace();
        } finally {
            closeStatement(pStmt);
            closeConnection(con);
        }
        return status;
    }

    @Override
    public String searchCustomerById(int customerID) {
        String userProfileAfterUpdation = null;
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT   customer_profilePicture"
                    + " FROM customer_details WHERE customer_ID = " + customerID;
            con = getConnection();
            stmt = getStatement(con);
            rs = getResultSet(stmt, sql);
            if (rs.next()) {
                userProfileAfterUpdation = rs.getString("customer_profilePicture");

            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            closeResultSet(rs);
            closeStatement(stmt);
            closeConnection(con);
        }
        return userProfileAfterUpdation ;
    }
}
