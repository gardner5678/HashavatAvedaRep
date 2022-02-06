package com.example.demo.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import com.example.demo.entities.Founds;
import com.example.demo.entities.Losts;
import com.example.demo.services.FoundService;
import com.example.demo.services.LostService;

public class SearchLogic {
	public final FoundService foundService;
	public final LostService lostService;
	
	
	public SearchLogic(FoundService foundService, LostService lostService) {
		this.foundService = foundService;
				this.lostService = lostService;
	}

	public List<Founds> UniversalSearchInFounds(Long categoryId, double lat, double lng, double radius) {
		List<Founds> founds = foundService.getAllFounds();
		ArrayList<Founds> newFounds = new ArrayList<>();
		// עובר על כל המציאות משווה קטגוריה ומיקום
		for (Founds f : founds) {
			if (f.getCategoryId() == categoryId && Distance(f.getFoundLat(), f.getFoundLng(), lat, lng) < radius) {
				newFounds.add(f);
			}
		}
		return newFounds;
	}

	public List<Founds> searchInFoundsWithManyParams(Losts myFound) {
		// איך להתייחס לקטגורית אחר?
		List<Founds> suitableLosts = new ArrayList<>();
		// סינון ראשוני לפי קטגוריה ופריט
		List<Founds> losts = UniversalSearchInFounds(myFound.getCategoryId(), myFound.getLostLat(), myFound.getLostLng(),
				myFound.getSearchRadius());
		/*-!!!!!לשנות את החומר לרדיוס!!!!=*/

		suitableLosts.addAll(SuitableLevel1Found(losts, myFound));
		suitableLosts.addAll(SuitableLevel2Found(losts, myFound));
		suitableLosts.addAll(SuitableLevel3Found(losts, myFound));
		return suitableLosts;
	}
	public List<Founds> SuitableLevel1Found(List<Founds> founds, Losts myLost)
	{
		List<Founds> suitableLevel1Found = new ArrayList<>();
		for (Founds f : founds)
		{
			if (IsSameMaterial(f, myLost) && IsSuitableColor(f, myLost)
					&& IsSuitableDateLevel1(f, myLost) && IsSuitableDescription(f, myLost))
				suitableLevel1Found.add(f);
		}
		return suitableLevel1Found;
	}
	public List<Founds> SuitableLevel2Found(List<Founds> founds, Losts myLost)
	{
		List<Founds> suitableLevel2Founds = new ArrayList<>();
		for (Founds f : founds)
		{
			if (IsSameMaterial(f, myLost) && IsSuitableDateLevel2(f, myLost) && IsSuitableDescription(f, myLost))
				suitableLevel2Founds.add(f);
		}
		return suitableLevel2Founds;
	}
    public List<Founds> SuitableLevel3Found(List<Founds> founds, Losts myLost)
    {
        List<Founds> suitableLevel3Found = new ArrayList<>();
        for (Founds f : founds)
        {
            if (IsSuitableDateLevel3(f, myLost))
                suitableLevel3Found.add(f);
        }
        return suitableLevel3Found;
    }
	public Boolean IsSameMaterial(Founds myFound, Founds l)
	{
		return l.getMaterialId() == myFound.getMaterialId();
	}
	public Boolean IsSuitableColor(Founds myFound, Founds l)
	{
		return(myFound.getColor1() == l.getColor1() ||
				myFound.getColor1() == l.getColor2() ||
				myFound.getColor1() == l.getColor3() ||
				myFound.getColor2() == l.getColor1() ||
				myFound.getColor2() == l.getColor2() ||
				myFound.getColor2() == l.getColor3() ||
				myFound.getColor3() == l.getColor1() ||
				myFound.getColor3() == l.getColor2() ||
				myFound.getColor3() == l.getColor3());
	}
	public List<Losts> UniversalSearchInLosts(Long categoryId, double lat, double lng, double radius) {
		List<Losts> losts = lostService.getAllLosts();
		ArrayList<Losts> newLosts = new ArrayList<>();
		// עובר על כל האבידות משווה קטגוריה ומיקום
		for (Losts l : losts) {
			if (l.getCategoryId() == categoryId && Distance(l.getLostLat(), l.getLostLng(), lat, lng) < radius) {
				newLosts.add(l);
			}
		}
		return newLosts;
	}

	public List<Losts> searchInLostsWithManyParams(Founds myFound)
	{
		//איך להתייחס לקטגורית אחר?
		List<Losts> suitableLosts = new ArrayList<>();
		//סינון ראשוני לפי קטגוריה ופריט
		List<Losts> losts = UniversalSearchInLosts(myFound.getCategoryId(), myFound.getFoundLat(), myFound.getFoundLng(), 1500);
		/*-!!!!!לשנות את החומר לרדיוס!!!!=*/


		//רשימה מסודרת לפי התאמה
		suitableLosts.addAll(SuitableLevel1Lost(losts, myFound));
		suitableLosts.addAll(SuitableLevel2Lost(losts, myFound));
		suitableLosts.addAll(SuitableLevel3Lost(losts, myFound));
		return suitableLosts;
	}
	public List<Losts> SuitableLevel1Lost(List<Losts> losts, Founds myFound)
	{
		List<Losts> suitableLevel1 = new ArrayList<>();
		for (Losts l : losts)
		{
			if (IsSameMaterial(myFound, l) && IsSuitableColor(myFound, l)
					&& IsSuitableDateLevel1(myFound, l) && IsSuitableDescription(myFound, l))
				suitableLevel1.add(l);
		}
		return suitableLevel1;
	}
	public List<Losts> SuitableLevel2Lost(List<Losts> losts, Founds myFound)
	{
		List<Losts> suitableLevel2 = new ArrayList<>();
		for (Losts l : losts)
		{
			if (IsSameMaterial(myFound, l) && IsSuitableDateLevel2(myFound, l) && IsSuitableDescription(myFound, l))
				suitableLevel2.add(l);
		}
		return suitableLevel2;
	}
    public List<Losts> SuitableLevel3Lost(List<Losts> losts, Founds myFound)
    {
        List<Losts> suitableLevel3 = new ArrayList<>();
        for (Losts l : losts)
        {
            if (IsSuitableDateLevel3(myFound, l))
                suitableLevel3.add(l);
        }
        return suitableLevel3;
    }
	public Boolean IsSameMaterial(Founds myFound, Losts l)
	{
		return l.getMaterialId() == myFound.getMaterialId();
	}
	public Boolean IsSuitableColor(Founds myFound, Losts l)
	{
		return(myFound.getColor1() == l.getColor1() ||
				myFound.getColor1() == l.getColor2() ||
				myFound.getColor1() == l.getColor3() ||
				myFound.getColor2() == l.getColor1() ||
				myFound.getColor2() == l.getColor2() ||
				myFound.getColor2() == l.getColor3() ||
				myFound.getColor3() == l.getColor1() ||
				myFound.getColor3() == l.getColor2() ||
				myFound.getColor3() == l.getColor3());
	}
	public Boolean IsSuitableDateLevel1(Founds myFound, Losts l)
	{
		return Math.abs(daysDiff(myFound.getFoundDate(),l.getLostDate())) <= 7;
	}
	public Boolean IsSuitableDescription(Founds myFound, Losts l)
	{
		//-----------------------28.07.2019----------------------------
		//יש לבדוק פונקציה מתאימה איך להשוות מחרוזות
		//---------------------------------------------------
		return (myFound.getFoundDescription().contains(l.getLostDescription()) ||
				l.getLostDescription().contains(myFound.getFoundDescription()));
	}
	public Boolean IsSuitableDateLevel2(Founds myFound, Losts l)
	{
		return Math.abs(daysDiff(myFound.getFoundDate(),l.getLostDate())) <= 30;
	}
	public Boolean IsSuitableDateLevel3(Founds myFound, Losts l)
	{
		return Math.abs(daysDiff(myFound.getFoundDate(),l.getLostDate())) <= 365;
	}
	
	public Long daysDiff(Date first, Date second) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
		Date firstDate = null;
		Date secondDate = null;
		try {
			firstDate = sdf.parse(first.toString());
			secondDate= sdf.parse(second.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
		Long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		//	
		//	    		    assertEquals(6, diff);
		return diff;
	}
	static double Distance(double x1, double y1, double x2, double y2) {
		double d = 100000.0 * (Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2) * 1.0));
		return d;
	}
}
