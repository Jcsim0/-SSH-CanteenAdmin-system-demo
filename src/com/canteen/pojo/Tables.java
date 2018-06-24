package com.canteen.pojo;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Tables entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tables", catalog = "canteen")
public class Tables implements java.io.Serializable
{

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer tablesId;
	private Integer tablesState;
	private Set<Orders> orderses = new HashSet<Orders>(0);

	// Constructors

	/** default constructor */
	public Tables()
	{
	}

	/** full constructor */
	public Tables(Integer tablesState, Set<Orders> orderses)
	{
		this.tablesState = tablesState;
		this.orderses = orderses;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "tables_id", unique = true, nullable = false)
	public Integer getTablesId()
	{
		return this.tablesId;
	}

	public void setTablesId(Integer tablesId)
	{
		this.tablesId = tablesId;
	}

	@Column(name = "tables_state")
	public Integer getTablesState()
	{
		return this.tablesState;
	}

	public void setTablesState(Integer tablesState)
	{
		this.tablesState = tablesState;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tables")
	public Set<Orders> getOrderses()
	{
		return this.orderses;
	}

	public void setOrderses(Set<Orders> orderses)
	{
		this.orderses = orderses;
	}

}