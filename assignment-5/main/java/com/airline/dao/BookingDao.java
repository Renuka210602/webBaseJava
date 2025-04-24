package com.airline.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.airline.entity.Booking;
import com.airline.util.JDBCUtils;

public class BookingDao {
	private String query;

		public boolean save(int userId, int flightId) {
			boolean status = false;
			query = "insert into booking(user_id,flight_id) values (?,?);";
			try(
					Connection con = JDBCUtils.getDbConnection();
					PreparedStatement pstm = con.prepareStatement(query);
					){
				pstm.setInt(1, userId);
				pstm.setInt(2, flightId);
				int count = pstm.executeUpdate();
				if(count>0) {
					System.out.println(count+ "Row inserted....");
					status=true;
				}
			}catch(Exception e) {
				System.err.println(e.getMessage());
			}
			return status;
		}
		
		public List<Booking> getAllFlights() {
			List<Booking> bookings = new ArrayList<Booking>();
			String query = "select * from booking";
			try (Connection conn = JDBCUtils.getDbConnection(); 
					Statement stmt = conn.createStatement();) {
				ResultSet st = stmt.executeQuery(query);

				while (st.next()) {
					bookings.add(new Booking(st.getInt("id"), st.getInt("user_id"), st.getInt("flight_id"),
							st.getDate("booking_date").toLocalDate()));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return bookings;
		}

		
		public boolean cancelFlight(int id)
		{
			Boolean status = false;
			String query = "delete from booking where id = ?;";
			try (Connection conn = JDBCUtils.getDbConnection(); PreparedStatement pstmt = conn.prepareStatement(query);) {
				pstmt.setInt(1, id);
				int count = pstmt.executeUpdate();
				if(count > 0)
					status = true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return status;
		}

	}

