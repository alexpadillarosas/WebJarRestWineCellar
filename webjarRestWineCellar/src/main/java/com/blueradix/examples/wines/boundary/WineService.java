package com.blueradix.examples.wines.boundary;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

import com.blueradix.examples.wines.entity.Wine;

@Stateless
public class WineService {

	private List<Wine> wines;

	@PostConstruct
	public void init() {
		wines = new ArrayList<>();
		setUpWines();
	}

	private void setUpWines() {

		Wine wine = new Wine();
		wine.setId(1);
		wine.setName("CHATEAU DE SAINT COSME");
		wine.setYear("2009");
		wine.setGrapes("Grenache / Syrah");
		wine.setCountry("France");
		wine.setRegion("Southern Rhone / Gigondas");
		wine.setDescription(
				"The aromas of fruit and spice give one a hint of the light drinkability of this lovely wine, which makes an excellent complement to fish dishes.");
		wine.setPicture("saint_cosme.jpg");

		wines.add(wine);

		wine = new Wine();
		wine.setId(2);
		wine.setName("LAN RIOJA CRIANZA");
		wine.setYear("2006");
		wine.setGrapes("Tempranillo");
		wine.setCountry("Spain");
		wine.setRegion("Rioja");
		wine.setDescription(
				"A resurgence of interest in boutique vineyards has opened the door for this excellent foray into the dessert wine market. Light and bouncy, with a hint of black truffle, this wine will not fail to tickle the taste buds.");
		wine.setPicture("lan_rioja.jpg");

		wines.add(wine);

		wine = new Wine();
		wine.setId(3);
		wine.setName("MARGERUM SYBARITE");
		wine.setYear("2010");
		wine.setGrapes("Sauvignon Blanc");
		wine.setCountry("USA");
		wine.setRegion("California Central Cosat");
		wine.setDescription(
				"The cache of a fine Cabernet in ones wine cellar can now be replaced with a childishly playful wine bubbling over with tempting tastes of\\nblack cherry and licorice. This is a taste sure to transport you back in time.");
		wine.setPicture("margerum.jpg");

		wines.add(wine);

		wine = new Wine();
		wine.setId(4);
		wine.setName("OWEN ROE \\\"EX UMBRIS\\\"");
		wine.setYear("2009");
		wine.setGrapes("Syrah");
		wine.setCountry("USA");
		wine.setRegion("Washington");
		wine.setDescription(
				"A one-two punch of black pepper and jalapeno will send your senses reeling, as the orange essence snaps you back to reality. Don\\'t miss\\nthis award-winning taste sensation.");
		wine.setPicture("ex_umbris.jpg");

		wines.add(wine);

		wine = new Wine();
		wine.setId(5);
		wine.setName("REX HILL");
		wine.setYear("2009");
		wine.setGrapes("Pinot Noir");
		wine.setCountry("USA");
		wine.setRegion("Oregon");
		wine.setDescription(
				"One cannot doubt that this will be the wine served at the Hollywood award shows, because it has undeniable star power. Be the first to catch\\nthe debut that everyone will be talking about tomorrow.");
		wine.setPicture("rex_hill.jpg");

		wines.add(wine);

		wine = new Wine();
		wine.setId(6);
		wine.setName("VITICCIO CLASSICO RISERVA");
		wine.setYear("2007");
		wine.setGrapes("Sangiovese Merlot");
		wine.setCountry("Italy");
		wine.setRegion("Tuscany");
		wine.setDescription(
				"Though soft and rounded in texture, the body of this wine is full and rich and oh-so-appealing. This delivery is even more impressive when one takes note of the tender tannins that leave the taste buds wholly satisfied.");
		wine.setPicture("viticcio.jpg");

		wines.add(wine);

	}

	public Wine addWine(Wine wine) {

		int max = wines.stream().mapToInt(x -> x.getId()).max().orElse(1);
		wine.setId(++max);
		wines.add(wine);
		return wine;
	}

	public List<Wine> findAll() {

		return wines;

	}

	public List<Wine> findByName(String name) {
		List<Wine> result = wines.stream().filter(x -> x.getName().toLowerCase().contains(name.toLowerCase()))
				.collect(Collectors.toList());
		return result;

	}

	public Wine findById(int id) {

		Wine wine = wines.stream().filter(x -> x.getId() == id).findFirst().orElse(null);

		return wine;
	}

	public Wine update(Wine wine) {
		Wine currentWine = wines.stream().filter(x -> x.getId() == wine.getId()).findFirst().orElse(null);
		int index = wines.indexOf(currentWine);
		if (index >= 0) {
			wines.set(index, wine);
			return wine;
		} else {
			return currentWine;
		}
	}

	public void remove(int id) {
		Wine wineToRemove = wines.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		if (null != wineToRemove)
			wines.remove(wineToRemove);
	}

}
