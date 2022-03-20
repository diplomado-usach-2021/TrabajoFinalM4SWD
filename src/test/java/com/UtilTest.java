package com;


import static org.junit.jupiter.api.Assertions.assertEquals;

import com.devops.dxc.devops.model.Dxc;
import com.devops.dxc.devops.model.Util;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;



public class UtilTest {
    
	Dxc diezxciento = new Dxc(40000000,2000000);

    @Autowired
    Util util;

	@Test
	public void testDiezxciento() throws Exception {
		Dxc diezxciento = new Dxc(40000000,2000000);
		assertEquals(4000000, diezxciento.getDxc());
	}

	@Test
	public void testImpuesto() throws Exception {
		assertEquals(400000, util.impuesto(diezxciento.getDxc(),2000000));

	}

	@Test
	public void testSaldoAhorro() throws Exception {
		assertEquals(36000000, util.saldoAhorro(diezxciento.getAhorro()));
	}
	

}
